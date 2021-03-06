var dat = {
  "legal.update": {
    numCols: 12 / 3,
    title:"parawisecomments.create.document.title",
    searchUrl:
      "/lcms-services/legalcase/case/_search?code={id}",
    url:
      "/lcms-services/legalcase/parawisecomment/_create",
    tenantIdRequired: true,
    useTimestamp: true,
    objectName: "cases",
    documentsPath:"cases[0].parawiseComments[0]",
    groups: [
       {
        name: "CaseTypeDetails",
        label: "legal.create.group.title.CaseTypeDetails",
        fields: [
          {
            name: "referenceNo",
            jsonPath: "cases[0].summon.summonReferenceNo",
            label: "legal.create.referenceNo",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "summonDate",
            jsonPath: "cases[0].summon.summonDate",
            label: "legal.create.summonDate",
            type: "datePicker",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "year",
            jsonPath: "cases[0].summon.year",
            label: "legal.create.year",
            type: "singleValueList",
            isRequired: false,
            isDisabled: true,
            url:
              "/egov-mdms-service/v1/_get?&moduleName=lcms&masterName=year|$..code|$..name",
            patternErrorMsg: ""
          },
          {
            name: "caseType",
            jsonPath: "cases[0].summon.caseType.code",
            label: "legal.create.caseType",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url:
              "/egov-mdms-service/v1/_get?&moduleName=lcms&masterName=caseType|$..code|$..name"
          },
          {
            name: "plantiffName",
            jsonPath: "cases[0].summon.plantiffName",
            label: "legal.create.plantiffName",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "caseNo",
            jsonPath: "cases[0].summon.caseNo",
            label: "legal.create.caseNo",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "plantiffAddress",
            jsonPath: "cases[0].summon.plantiffAddress.addressLine1",
            label: "legal.create.plantiffAddress",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "caseDetails",
            jsonPath: "cases[0].summon.caseDetails",
            label: "legal.create.caseDetails",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "defendant",
            jsonPath: "cases[0].summon.defendant",
            label: "legal.create.defendant",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "departmentName",
            jsonPath: "cases[0].summon.departmentName.code",
            label: "legal.create.departmentName",
            type: "singleValueList",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: "",
            url: "/egov-common-masters/departments/_search?|$..code|$..name"
          },
           {
            name: "courtName",
            jsonPath: "cases[0].summon.courtName.code",
            label: "legal.create.courtName",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url:
              "/egov-mdms-service/v1/_get?&moduleName=lcms&masterName=court|$..code|$..name"
          },
          {
            name: "hearingTime",
            jsonPath: "cases[0].summon.hearingTime",
            label: "legal.create.hearingTime",
            isRequired: false,
            type:"timePicker",
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "hearingDate",
            jsonPath: "cases[0].summon.hearingDate",
            label: "legal.create.hearingDate",
            type: "datePicker",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          },
          {
            name: "side",
            jsonPath: "cases[0].summon.side.code",
            label: "legal.create.side",
            type: "singleValueList",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: "",
            url:
              "/egov-mdms-service/v1/_get?&moduleName=lcms&masterName=side|$..code|$..name"
          },
          {
            name: "ward",
            jsonPath: "cases[0].summon.ward",
            label: "legal.create.ward",
            type: "singleValueList",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: "",
            url:"/egov-location/boundarys/getByBoundaryType?tenantId=default&boundaryTypeId=10|$.Boundary.*.id|$.Boundary.*.name"
          },
         {
            name: "stamp",
            jsonPath: "cases[0].summon.register.code",
            label: "legal.create.stamp",
            type: "singleValueList",
            isRequired: true,
            isDisabled: false,
            patternErrorMsg: "",
            url:
              "/lcms-services/legalcase/register/_search?|$..code|$..register"
          },
          {
            name: "bench",
            jsonPath: "cases[0].summon.bench.code",
            label: "legal.create.bench",
            type: "singleValueList",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: "",
            url:
              "/egov-mdms-service/v1/_get?&moduleName=lcms&masterName=bench|$..code|$..name"
          },
          {
            name: "sectionApplied",
            jsonPath: "cases[0].summon.sectionApplied",
            label: "legal.create.sectionApplied",
            type: "text",
            isRequired: false,
            isDisabled: true,
            patternErrorMsg: ""
          }
        ]
      },
      {
        label: "legal.parawisecomments.create.group.title.parawiseComment",
        name: "parawiseComments",
        fields: [
          {
            name: "parawiseCommentsAskedDate",
            jsonPath: "cases[0].parawiseComments[0].parawiseCommentsAskedDate",
            label: "legal.parawisecomments.create.dateOfCommentsAsked",
            pattern: "",
            type: "datePicker",
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          {
            name: "parawiseCommentsReceivedDate",
            jsonPath:
              "cases[0].parawiseComments[0].parawiseCommentsReceivedDate",
            label: "legal.parawisecomments.create.dateOfCommentsReceived",
            pattern: "",
            type: "datePicker",
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          {
            name: "hodProvidedDate",
            jsonPath: "cases[0].parawiseComments[0].hodProvidedDate",
            label: "legal.parawisecomments.create.dateOfInfoProvidedByHod",
            pattern: "",
            type: "datePicker",
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          {
            name: "resolutionDate",
            jsonPath: "cases[0].parawiseComments[0].resolutionDate",
            label: "legal.parawisecomments.create.resolutionDate",
            pattern: "",
            type: "datePicker",
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          {
            name: "caseReferenceNo",
            jsonPath: "cases[0].caseRefernceNo",
            label: "legal.parawisecomments.create.caseReferenceNo",
            pattern: "",
            type: "text",
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          {
            name: "paraWiseComments",
            jsonPath: "cases[0].parawiseComments[0].paraWiseComments",
            label: "legal.parawisecomments.create.group.parawiseComments",
            pattern: "",
            type: "textarea",
            fullWidth:true,
            isRequired: true,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          }
        ]
      },
      {
        name: "documents",
        label: "legal.parawisecomments.create.group.title.uploadDocument",
        fields: [
          {
            name: "documents",
            jsonPath: "cases[0].parawiseComments[0].documents",
            label: "legal.create.sectionApplied",
            type: "fileTable",
            isRequired: false,
            isDisabled: false,
            patternErrMsg: "",
            fileList: {
               name:"documentName",
                id:"fileStoreId"
            },
            fileCount: 3
          }
        ]
      },
      {
        name: "action",
        label: "legal.parawisecomments.create.group.title.action",
        hide:true,
        fields: [
          {
            name: "approve",
            jsonPath: "parawiseComments[0].approve",
            label: "",
            type: "radio",
            styleObj:{"display": "-webkit-box"},
            isRequired: false,
            isDisabled: false,
            patternErrorMsg: "",
            values: [
              {
                label: "legal.parawisecomments.create.approve",
                value: true
              },
              {
                label: "legal.parawisecomments.create.reject",
                value: false
              }
            ]
          },
          {
            name: "forwardTo",
            jsonPath: "parawiseComments[0].forwardTo",
            label: "legal.parawisecomments.create.forwardTo",
            url: "",
            pattern: "",
            type: "singleValueList",
            isRequired: false,
            isDisabled: false,
            requiredErrMsg: "",
            patternErrMsg: ""
          },
          
        ]
      }
    ]
  }
};

export default dat;