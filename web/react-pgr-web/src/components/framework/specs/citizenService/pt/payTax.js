var dat = {
  "noDues.create": {
    "numCols": 12 / 3,
    "url": "/wcms/masters/pipesize/_create",
    "tenantIdRequired": true,
    "idJsonPath": "PipeSizes[0].code",
    "objectName": "pipeSize",
    "groups": [{
      "label": "noDues.create.pipeSize.title",
      "name": "createpipeSize",
      "fields": [{
          "name": "name",
          "jsonPath": "pipeSize[0].sizeInMilimeter",
          "label": "noDues.create.mm",
          "pattern": "^\\d+(\\.\\d+)?$",
          "type": "number",
          "isRequired": true,
          "isDisabled": false,
          "requiredErrMsg": "Please Enter valid Number",
          "patternErrMsg": "",
          "depedants": [{
            "jsonPath": "pipeSize[0].sizeInInch",
            "type": "textField",
            "pattern": "`${getVal('pipeSize.sizeInMilimeter')!=''?getVal('pipeSize.sizeInMilimeter'):0} * 0.039370`",
            "rg": "",
            "isRequired": false,
            "requiredErrMsg": "",
            "patternErrMsg": ""
          }]
        },
        {
          "name": "description",
          "jsonPath": "pipeSize[0].sizeInInch",
          "label": "noDues.create.groups.connectionDetails.hscPipeSizeType",
          "pattern": "^[\s.]*([^\s.][\s.]*){0,250}$",
          "type": "number",
          "isRequired": false,
          "isDisabled": true,
          "requiredErrMsg": "",
          "patternErrMsg": "Length is more than 250"
        },
        {
          "name": "description",
          "jsonPath": "pipeSize[0].description",
          "label": "noDues.create.description",
          "pattern": "",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "Active",
          "jsonPath": "pipeSize[0].active",
          "label": "noDues.create.active",
          "pattern": "",
          "type": "checkbox",
          "isRequired": false,
          "isDisabled": false,
          "defaultValue": true,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        }
      ]
    }]
  },
  "noDues.search": {
    "numCols": 12 / 2,
    "url": "billing-service/demand/_search",
    "tenantIdRequired": true,
    "useTimestamp": true,
    "objectName": "",
    "groups": [{
      "label": "noDues.search.citizenServices.title",
      // "description":"noDues.search.citizenServices.description",
      "name": "search",
      "fields": [{
          "name": "consumerCode",
          "jsonPath": "consumerCode",
          "label": "noDues.citizenService.assessmentNumber",
          "pattern": "^[-0-9a-zA-Z]{0,30}$",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "Consumer code is mandatory",
          "patternErrMsg": "Cosumer code max 30 charectors"
        },
        {
          "name": "email",
          "jsonPath": "email",
          "label": "noDues.citizenService.email",
          "pattern": "^[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "Email addrees is required",
          "patternErrMsg": "Please provide proper email address"

        },
        {
          "name": "mobileNumber",
          "jsonPath": "mobileNumber",
          "label": "noDues.citizenService.mobileNumber",
          "pattern": "^[0-9]{10,10}$",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "Mobile number is mandatory",
          "patternErrMsg": "Please provide proper mobile number"
        },
        {
          "name": "businessService",
          "jsonPath": "businessService",
          "label": "Billing service name",
          "pattern": "",
          "type": "singleValueList",
          "isRequired": false,
          "isDisabled": false,
          "url": "/egov-common-masters/businessDetails/_search?tenantId=default|$..code|$..name",
          "requiredErrMsg": "",
          "patternErrMsg": "",
          "hide": true,
          "defaultValue": "PT"
        }
      ]
    }],
    "result": {
      "header": [{
        label: "Business Code"
      }, {
        label: "Tax period"
      }, {
        label: "Amount"
      }],
      "values": ["code", "sizeInInch", "sizeInMilimeter"],
      "resultPath": "PipeSizes",
      "rowClickUrlUpdate": "/update/wc/pipeSize/{id}",
      "rowClickUrlView": "/view/wc/pipeSize/{id}"
    },
    "feeDetails": [{
      "id": null,
      "tenantId": window.localStorage.getItem("tenantId"),
      "consumerCode": "",
      "consumerType": "consumertype1",
      "businessService": "CS",
      "minimumAmountPayable": 10,
      "owner": {
        "id": 0,
        "userName": null,
        "name": null,
        "type": null,
        "mobileNumber": null,
        "emailId": null,
        "roles": null
      },
      "taxPeriodFrom": 0,
      "taxPeriodTo":0,
      "demandDetails": [{
        "id": null,
        "demandId": null,
        "taxHeadMasterCode": "",
        "taxAmount": 20,
        "collectionAmount": 0
      }]
    }]
  },
  "noDues.view": {
    "numCols": 12 / 3,
    "url": "/wcms/masters/pipesize/_search?id={id}",
    "tenantIdRequired": true,
    "useTimestamp": true,
    "objectName": "PipeSizes",
    "groups": [{
      "label": "noDues.view.PipeSize.title",
      "name": "viewPipeSize",
      "fields": [{
          "name": "code",
          "jsonPath": "PipeSizes[0].code",
          "label": "noDues.create.code",
          "pattern": "",
          "type": "text",
          "isRequired": true,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "sizeInMilimeter",
          "jsonPath": "PipeSizes[0].sizeInMilimeter",
          "label": "noDues.create.mm",
          "pattern": "",
          "type": "checkbox",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "sizeInInch",
          "jsonPath": "PipeSizes[0].sizeInInch",
          "label": "noDues.create.groups.connectionDetails.hscPipeSizeType",
          "pattern": "",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "description",
          "jsonPath": "PipeSizes[0].description",
          "label": "noDues.create.description",
          "pattern": "",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "active",
          "jsonPath": "PipeSizes[0].active",
          "label": "noDues.create.active",
          "pattern": "",
          "type": "checkbox",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        }
      ]
    }]
  },
  "noDues.update": {
    "numCols": 12 / 3,
    "searchUrl": "/wcms/masters/pipesize/_search?id={id}",
    "url": "/wcms/masters/pipesize/{PipeSize.code}/_update",
    "tenantIdRequired": true,
    "useTimestamp": true,
    "objectName": "PipeSize",
    "groups": [{
      "label": "noDues.update.pipesize.title",
      "name": "updatePipeSize",
      "fields": [{
          "name": "name",
          "jsonPath": "PipeSize[0].sizeInMilimeter",
          "label": "noDues.create.mm",
          "pattern": "",
          "type": "number",
          "isRequired": true,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": "",
          "depedants": [{
            "jsonPath": "PipeSize.sizeInInch",
            "type": "textField",
            "pattern": "`${getVal('PipeSize.sizeInMilimeter')!=''?getVal('PipeSize.sizeInMilimeter'):0} * 0.039370`",
            "rg": "",
            "isRequired": false,
            "requiredErrMsg": "",
            "patternErrMsg": ""
          }]
        },
        {
          "name": "sizeInInch",
          "jsonPath": "PipeSize[0].sizeInInch",
          "label": "noDues.create.groups.connectionDetails.hscPipeSizeType",
          "pattern": "",
          "type": "number",
          "isRequired": false,
          "isDisabled": true,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "description",
          "jsonPath": "PipeSize[0].description",
          "label": "noDues.create.description",
          "pattern": "",
          "type": "text",
          "isRequired": false,
          "isDisabled": false,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        },
        {
          "name": "Active",
          "jsonPath": "PipeSize[0].active",
          "label": "noDues.create.active",
          "pattern": "",
          "type": "checkbox",
          "isRequired": false,
          "isDisabled": false,
          "defaultValue": true,
          "requiredErrMsg": "",
          "patternErrMsg": ""
        }
      ]
    }]
  }
}

export default dat;