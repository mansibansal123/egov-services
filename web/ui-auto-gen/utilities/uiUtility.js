var utilities = require('./utility');
const getTitleCase = utilities.getTitleCase;
const getType = utilities.getType;
const getQuery = utilities.getQuery;

let getFieldsFromInnerObject = function(fields, properties, module, jPath, isArray, required) {
    let errors = {};
    let localeFields = {};

    for (let key in properties) {
        if (["id", "tenantId", "auditDetails", "assigner"].indexOf(key) > -1) continue;

        if(properties[key].properties) {
            getFieldsFromInnerObject(fields, properties[key].properties, module, (isArray ? (jPath + "[0]") : jPath) + "." + key, false, (properties[key].properties.required || []));
        } else if(properties[key].item && properties[key].item.properties) {
            getFieldsFromInnerObject(fields, properties[key].item.properties, module, (isArray ? (jPath + "[0]") : jPath) + "." + key, true, (properties[key].properties.required || []));
        } else {
            localeFields[module + ".create." + key] = getTitleCase(key);
            fields[(isArray ? (jPath + "[0]") : jPath) + "." + key] = {
                "name": key,
                "jsonPath": (isArray ? (jPath + "[0]") : jPath) + "." + key,
                "label": module + ".create." + key,
                "pattern": properties[key].pattern || "",
                "type": properties[key].enum ? "singleValueList" : properties[key].format && ["number", "integer", "double", "long", "float"].indexOf(properties[key].type) == -1 ? getType(properties[key].format) : getType(properties[key].type),
                "isRequired": (properties[key].required || (required && required.constructor == Array && required.indexOf(key) > -1) ? true : false),
                "isDisabled": properties[key].readOnly ? true : false,
                "defaultValue": properties[key].default || "",
                "maxLength": properties[key].maxLength,
                "minLength": properties[key].minLength,
                "patternErrorMsg": properties[key].pattern ? (module + ".create.field.message." + key) : ""
            };

            if (fields[(isArray ? (jPath + "[0]") : jPath) + "." + key].type == "text" && properties[key].maxLength && properties[key].maxLength > 256)
                fields[(isArray ? (jPath + "[0]") : jPath) + "." + key].type = "textarea";

        }
    }
    return {
        fields,
        errors,
        localeFields
    };
}

let addUrls = function(fields, uiInfoDef) {
    let errors = {};
    for (var i = 0; i < uiInfoDef.externalData.length; i++) {
        if (fields[uiInfoDef.externalData[i].fieldName]) {
            if (fields[uiInfoDef.externalData[i].fieldName].type == "autoCompelete")
                fields[uiInfoDef.externalData[i].fieldName].autoCompleteUrl = uiInfoDef.externalData[i].url + getQuery(uiInfoDef.externalData[i].url, uiInfoDef.externalData[i].keyPath, uiInfoDef.externalData[i].valPath);
            else
                fields[uiInfoDef.externalData[i].fieldName].url = uiInfoDef.externalData[i].url + getQuery(uiInfoDef.externalData[i].url, uiInfoDef.externalData[i].keyPath, uiInfoDef.externalData[i].valPath);
        } else {
            errors[uiInfoDef.externalData[i].fieldName] = "Field exists in x-ui-info externalData section but not present in API specifications. REFERENCE PATH: " + uiInfoDef.referencePath;
        }
    }

    return {
        fields,
        errors
    }
}

let addDependents = function(fields, uiInfoDef) {
    let errors = {};
    for (let i = 0; i < uiInfoDef.dependents.length; i++) {
        if (fields[uiInfoDef.dependents[i].onChangeField]) {
            fields[uiInfoDef.dependents[i].onChangeField].depedants = [];
            for (let key in uiInfoDef.dependents[i].affectedFields) {
                fields[uiInfoDef.dependents[i].onChangeField].depedants.push({
                    "jsonPath": key,
                    "type": uiInfoDef.dependents[i].affectedFields[key].type,
                    "pattern": uiInfoDef.dependents[i].affectedFields[key].pattern
                })
            }
        }
    }

    return {
        fields,
        errors
    };
}

let addAutoFills = function(fields, uiInfoDef) {
    let errors = {};
    for (var i = 0; i < uiInfoDef.autoFills.length; i++) {
        if (fields[uiInfoDef.autoFills[i].onChangeField]) {
            fields[uiInfoDef.autoFills[i].onChangeField].type = "textSearch";
            fields[uiInfoDef.autoFills[i].onChangeField].autoCompleteDependancy = {
                autoCompleteUrl: uiInfoDef.autoFills[i].url,
                autoFillFields: {}
            };

            for (var j = 0; j < uiInfoDef.autoFills[i].affectedFields.length; j++) {
                fields[uiInfoDef.autoFills[i].onChangeField].autoCompleteDependancy.autoFillFields[uiInfoDef.autoFills[i].affectedFields[j]] = uiInfoDef.autoFills[i].affectJSONPath[j];
            }
        } else {
            errors[uiInfoDef.autoFills[i].onChangeField] = "Field exists in x-ui-info AutoFills section but not present in API specifications. REFERENCE PATH: " + uiInfoDef.referencePath;
        }
    }

    return {
        fields,
        errors
    };
}

let addRadios = function(fields, uiInfoDef, module) {
    let errors = {};
    let localeFields = {};
    for (var i = 0; i < uiInfoDef.radios.length; i++) {
        if (fields[uiInfoDef.radios[i].jsonPath]) {
            fields[uiInfoDef.radios[i].jsonPath].type = "radio";
            localeFields[module + ".create." + uiInfoDef.radios[i].trueLabel] = getTitleCase(uiInfoDef.radios[i].trueLabel);
            localeFields[module + ".create." + uiInfoDef.radios[i].falseLabel] = getTitleCase(uiInfoDef.radios[i].falseLabel);
            fields[uiInfoDef.radios[i].jsonPath].values = [{
                label: module + ".create." + uiInfoDef.radios[i].trueLabel,
                value: true
            }, {
                label: module + ".create." + uiInfoDef.radios[i].falseLabel,
                value: false
            }];
        } else {
            errors[uiInfoDef.radios[i].jsonPath] = "Field exists in x-ui-info radios section but not present in API specifications. REFERENCE PATH: " + uiInfoDef.referencePath;
        }
    }

    return {
        fields,
        errors,
        localeFields
    };
}

let addGroups = function(specifications, fields, uiInfoDef, module) {
    let errors = {};
    let localeFields = {};
    for (var key in uiInfoDef.groups) {
        localeFields[module + ".create.group.title." + key] = getTitleCase(key);
        let group = {
            name: key,
            label: module + ".create.group.title." + key,
            fields: []
        };
        for (var i = 0; i < uiInfoDef.groups[key].fields.length; i++) {
            if (fields[uiInfoDef.groups[key].fields[i]])
                group.fields.push(fields[uiInfoDef.groups[key].fields[i]]);
            else
                errors[uiInfoDef.groups[key].fields[i]] = "Field exists in x-ui-info groups section but not present in API specifications. REFERENCE PATH: " + uiInfoDef.referencePath;
        }
        specifications.groups.push(group);
    }

    return {
        specifications,
        errors,
        localeFields
    }
}

exports.getFieldsFromInnerObject = getFieldsFromInnerObject;
exports.addUrls = addUrls;
exports.addDependents = addDependents;
exports.addAutoFills = addAutoFills;
exports.addRadios = addRadios;
exports.addGroups = addGroups;