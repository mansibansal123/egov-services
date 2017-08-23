var dat = {
	"pt.create": {
		"numCols": 12/3,
		"version": "v1",
		"url": "pt-property/properties/_create",
		"useTimestamp": true,
		"objectName": "properties",
		"level": 0,
		"groups": [
			{
				"label": "Property Address",
				"name": "propertyAddress",
				"fields": [
						{
							"name": "ReferencePropertyNumber",
							"jsonPath": "",
							"label": "Reference property number",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Appartment/Complex name",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Locality *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Election ward *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Zone No. *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Ward No. *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Block No.",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Street",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Revenue circle *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Door No. *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Pin",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Is correspondence address different from property address?",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			},
			{
				"label": "Amenities",
				"name": "Amenities",
				"fields": [
						{
							"name": "",
							"jsonPath": "",
							"label": "Lift",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Toilet",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "water tap",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "electricity",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},{
							"name": "",
							"jsonPath": "",
							"label": "Attached bathroom",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},{
							"name": "",
							"jsonPath": "",
							"label": "Cable connection",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},{
							"name": "",
							"jsonPath": "",
							"label": "Water harvesting",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
			,{
				"label": "assessmentDetails",
				"name": "Assessment details",
				"fields": [
						{
							"name": "",
							"jsonPath": "",
							"label": "Reason for Creation *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Property Type *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Property Sub-type *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Department *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Extent of Site (Sq. Mtrs) *",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			},{
				"label": "workflow",
				"name": "Workflow",
				"fields": [
						{
							"name": "departmentName",
							"jsonPath": "",
							"label": "Department Name",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "/egov-common-masters/departments/_search?tenantId=default|$..id|$..name",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "designation",
							"jsonPath": "connection.workflowDetails.designation",
							"label": "Designation Name",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "",
							"jsonPath": "",
							"label": "Approver Name",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	}
}

export default dat;


//doubts

//Reference property number