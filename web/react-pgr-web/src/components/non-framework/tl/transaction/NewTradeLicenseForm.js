import React, {Component} from 'react';
import RaisedButton from 'material-ui/RaisedButton';
import NewCard from '../utils/NewCard';
import SupportingDocuments from '../utils/SupportingDocuments';
import {Grid} from 'react-bootstrap';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';
import _ from "lodash";
import Acknowledgement from './Acknowledgement';
import {translate, dateToEpoch} from '../../../common/common';
import Api from '../../../../api/api';
import styles from '../../../../styles/material-ui';
const constants = require('../../../common/constants');

const patterns = {
  date:/^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g,
  ownerName:/^.[a-zA-Z. ]{2,99}$/,
  address:/^[a-zA-Z0-9:@&*_+#()/,. -]*$/,
  assessmentNumber : /^[a-z0-9\/\-]+$/,
  tradeTitle : /^[a-zA-Z0-9@:()/#,. -]*$/,
  remarks:/^[a-zA-Z0-9:@&*_+#()/,. -]*$/,
  agreementNo : /^[a-zA-Z0-9&/()-]*$/,
  quantity : /^[+-]?\d+(\.\d{1,2})?$/
}

const tradeOwnerDetailsCardFields = [
  {label : "tl.create.licenses.groups.TradeOwnerDetails.AadharNumber", type:"text", code:"adhaarNumber", isMandatory:false, maxLength:12, pattern:/^\d{12}$/g, errorMsg:"Enter Valid Aadhar Number (12 Digit Number)"},
  {label : "tl.create.licenses.groups.TradeOwnerDetails.Mobile Number", type:"text", code:"mobileNumber", isMandatory:true, maxLength:10, pattern:/^\d{10}$/g, errorMsg:"Enter Valid Mobile Number (10 Digit Number)"},
  {label : "tl.create.licenses.groups.TradeOwnerDetails.TradeOwnerName", type:"text", code:"ownerName", isMandatory:true, maxLength:100, pattern:patterns.ownerName, errorMsg:"Enter Valid Trade Owner Name(Min:3, Max:100)"},
  {label : "tl.create.licenses.groups.TradeOwnerDetails.FatherSpouseName", type:"text", code:"fatherSpouseName", isMandatory:true, maxLength:100, pattern:patterns.ownerName, errorMsg:"Enter Valid Father/Spouse Name(Min:3, Max:100)"},
  {label : "tl.create.licenses.TradeOwnerDetails.groups.EmailID", code:"emailId", type:"text", isMandatory:true, maxLength:50, pattern:/^(?=.{6,64}$)(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/, errorMsg:"Enter Valid Email ID (Max:50)"},
  {label : "tl.create.licenses.groups.TradeOwnerDetails.TradeOwnerAddress", type:"textarea", code:"ownerAddress", isMandatory:true, maxLength:250, pattern:patterns.address, errorMsg:"Enter Valid Trade Owner Address (Max:250)"}
]

const tradeLocationDetails = [
  {label : "tl.create.licenses.groups.TradeLocationDetails.PropertyAssessmentNo", type:"text", code:"propertyAssesmentNo", isMandatory:false, maxLength:20, pattern:patterns.assessmentNumber, errorMsg:"Enter Valid Property Assessment Number (Max:20)"},
  {label : "tl.create.licenses.groups.TradeLocationDetails.Locality", type:"dropdown", code:"localityId", codeName:"localityName", isMandatory:true, maxLength:50, pattern:""},
  {label : "tl.create.licenses.groups.TradeLocationDetails.adminWardId", type:"dropdown", code:"adminWardId", codeName:"adminWardName", isMandatory:true, maxLength:50, pattern:""},
  {label : "tl.create.licenses.groups.TradeLocationDetails.revenueWardId", type:"dropdown", code:"revenueWardId", codeName:"revenueWardName", isMandatory:true, maxLength:100, pattern:""},
  {label : "tl.create.licenses.groups.TradeLocationDetails.OwnershipType", code:"ownerShipType", type:"dropdown", isMandatory:true, maxLength:50, pattern:""},
  {label : "tl.create.licenses.groups.TradeLocationDetails.TradeAddress", type:"textarea", code:"tradeAddress", isMandatory:true, maxLength:250, pattern:patterns.address, errorMsg:"Enter Valid Trade Address (Max:250)"}
]

const tradeDetails = [
  {label : "tl.create.licenses.groups.TradeDetails.TradeTitle", type:"text", code:"tradeTitle", isMandatory:true, maxLength:100, pattern:patterns.tradeTitle, errorMsg:"Enter Valid Trade Title (Max: 250)"},
  {label : "tl.create.licenses.groups.TradeDetails.TradeType", type:"dropdown", code:"tradeType", isMandatory:true, maxLength:50, pattern:""},
  {label : "tl.create.licenses.groups.TradeDetails.TradeCategory", type:"dropdown", code:"categoryId", codeName:'category', isMandatory:true, maxLength:50, pattern:""},
  {label : "tl.create.licenses.groups.TradeDetails.TradeSubCategory", type:"dropdown", code:"subCategoryId", codeName:"subCategory", isMandatory:true, maxLength:100, pattern:""},
  {label : "tl.create.licenses.groups.TradeDetails.UOM", code:"uom", codeName:"uomId", type:"text", isMandatory:true, maxLength:50, pattern:"", isDisabled:true},
  {label : "tl.create.licenses.groups.TradeDetails.tradeValueForUOM", type:"text", code:"quantity", isMandatory:true, maxLength:50, pattern: patterns.quantity, errorMsg:"Enter Valid Trade Value for the UOM (Upto two decimal points)"},
  {label : "tl.create.licenses.groups.validity", type:"text", code:"validityYears", isMandatory:true, maxLength:50, pattern:"", isDisabled:true},
  {label : "tl.create.licenses.groups.TradeDetails.Remarks", type:"textarea", code:"remarks", isMandatory:false, maxLength:1000, pattern:patterns.remarks, errorMsg:"Please avoid sepcial characters except :@&*_+#()/,.-"},
  {label : "tl.create.licenses.groups.TradeDetails.TradeCommencementDate", type:"date", code:"tradeCommencementDate", isMandatory:true, maxLength:1000, pattern:patterns.date, errorMsg:"Enter in dd/mm/yyyy Format"},
  {label : "tl.create.licenses.groups.TradeDetails.TraderOwnerProperty", type:"checkbox", code:"isPropertyOwner", isMandatory:false}
]

const agreementDetailsSection = [
  {label : "tl.create.licenses.groups.agreementDetails.agreementDate", type:"date", code:"agreementDate", isMandatory:true, maxLength:10, pattern:patterns.date,  errorMsg:"Enter in dd/mm/yyyy Format"},
  {label : "tl.create.licenses.groups.agreementDetails.agreementNo", type:"text", code:"agreementNo", isMandatory:true, maxLength:30, pattern:patterns.agreementNo, errorMsg:"Enter Valid Agreement No (Max:30, Alpha/Numeric)"}
]

const customStyles={
  cardTitle:{
    padding: '16px 16px 0'
  },
  th:{
    padding:'15px 10px !important'
  },
  fileInput: {
    cursor: 'pointer',
     position: 'absolute',
     top: 0,
     bottom: 0,
     right: 0,
     left: 0,
     width: '100%',
     opacity: 0
  }
}

function compareStrings(a, b) {
  // Assuming you want case-insensitive comparison
  a = a.toLowerCase();
  b = b.toLowerCase();

  return (a < b) ? -1 : (a > b) ? 1 : 0;
}

function sortArrayByAlphabetically(arry, keyToSort){
  return arry.sort(function(a, b) {
    return compareStrings(a[keyToSort], b[keyToSort]);
  });
}

export default class NewTradeLicenseForm extends Component {

  constructor(){
    super();
    this.customHandleChange = this.customHandleChange.bind(this);
    this.handleDocumentsClearCancel = this.handleDocumentsClearCancel.bind(this);
    this.handleDocumentsClearConfirm = this.handleDocumentsClearConfirm.bind(this);

    this.state={
      isPropertyOwner:true,
      openDocClearDialog:false,
      documentTypes:[], //supporting documents
      autocompleteDataSource:{
        localityId:[], //assigning datasource by field code
        localityIdConfig: { //autocomplete config
         text: 'name',
         value: 'id'
        }
      },
      confirmCategoryField:{}, //category or subcategory field confirm temporary store
      confirmCategoryFieldValue:"",
      supportDocClearDialogMsg : translate('tl.create.supportDocuments.clear.basedonCategory'),
      dropdownDataSource:{
        adminWardId:[],
        adminWardIdConfig: {
          text: 'name',
          value: 'id'
        },
        revenueWardId:[],
        revenueWardIdConfig: {
          text: 'name',
          value: 'id'
        },
        categoryId:[],
        categoryIdConfig: {
          text: 'name',
          value: 'id'
        },
        subCategoryId:[],
        subCategoryIdConfig:{
          text: 'name',
          value: 'id'
        },
        tradeType:[{
          id:"PERMANENT",
          name:"PERMANENT"
        },
        {
          id:"TEMPORARY",
          name:"TEMPORARY"
        }],
        tradeTypeConfig: {
          text: 'name',
          value: 'id'
        },
        ownerShipType:[
          {
            id:"OWNED",
            name:"OWNED"
          },
          {
            id:"RENTED",
            name:"RENTED"
          },
          {
            id:"ULB",
            name:"ULB"
          },
          {
            id:"STATE_GOVERNMENT",
            name:"STATE GOVERNMENT"
          },
          {
            id:"CENTRAL_GOVERNMENT",
            name:"CENTRAL GOVERNMENT"
          }
        ],
        ownerShipTypeConfig: {
          text: 'name',
          value: 'id'
        },
        localityId:[],
        localityIdConfig:{
          text: 'name',
          value: 'id'
        }
      }
    }
  }

  componentDidMount(){
    let requiredFields = [];

    tradeOwnerDetailsCardFields.filter(function(obj){
      obj.isMandatory ? requiredFields.push(obj.code) : '';
    });

    tradeLocationDetails.filter(function(obj){
      obj.isMandatory ? requiredFields.push(obj.code) : '';
    });

    tradeDetails.filter(function(obj){
      obj.isMandatory ? requiredFields.push(obj.code) : '';
    });

    this.props.initForm(requiredFields);

    var tenantId = localStorage.getItem("tenantId") || "default";

    this.props.setLoadingStatus('loading');

    Promise.all([
      Api.commonApiPost("/egov-location/boundarys/boundariesByBndryTypeNameAndHierarchyTypeName",{boundaryTypeName:"WARD", hierarchyTypeName:"REVENUE"},{tenantId:tenantId}),
      Api.commonApiPost("/egov-location/boundarys/boundariesByBndryTypeNameAndHierarchyTypeName",{boundaryTypeName:"Ward", hierarchyTypeName:"ADMINISTRATION"},{tenantId:tenantId}),
      Api.commonApiPost("/tl-masters/category/v1/_search",{type:"category", active:true},{tenantId:tenantId, pageSize:"500"}, false, true),
      Api.commonApiPost("/egov-location/boundarys/boundariesByBndryTypeNameAndHierarchyTypeName",{boundaryTypeName:"LOCALITY", hierarchyTypeName:"LOCATION"},{tenantId:tenantId})
      // Api.commonApiPost("/tl-masters/documenttype/v2/_search",{applicationType:"NEW",enabled : true},{tenantId:tenantId})
    ])
    .then((responses)=>{
      //if any error occurs
      // if(!responses || responses.length ===0 || !responses[0] || !responses[1]){
      //   return;
      // }
      this.props.setLoadingStatus('hide');
      try{
        let revenueWardId = sortArrayByAlphabetically(responses[0].Boundary, "name");
        let adminWardId = sortArrayByAlphabetically(responses[1].Boundary, "name");
        let categoryId = sortArrayByAlphabetically(responses[2].categories, "name");
        let localityId = sortArrayByAlphabetically(responses[3].Boundary, "name");
        let dropdownDataSource = {...this.state.dropdownDataSource};
        dropdownDataSource = {...dropdownDataSource, revenueWardId, adminWardId, categoryId, localityId};
        this.setState({dropdownDataSource});
      }
      catch(e){
        console.log('error', e);
      }

    });

  }

  fileSectionChange = (comments, doc) => {
    this.props.handleChange(comments, doc.id+'_comments', false, "")
  }

  handleDocumentsClearConfirm(){
    //console.log('confirm clicked', field);
    if(this.state.confirmCategoryField.code === 'categoryId'){
      this.tradeCategoryChangeAndResetFields(this.state.confirmCategoryField, this.state.confirmCategoryFieldValue);
    }
    else if(this.state.confirmCategoryField.code === 'subCategoryId'){
      this.tradeSubCategoryChangeAndResetFields(this.state.confirmCategoryField, this.state.confirmCategoryFieldValue);
    }
  }

  handleDocumentsClearCancel(){
    this.setState({openDocClearDialog:false});
  }

  clearSupportDocuments(){
    var supportDocuments= this.state.documentTypes ? [...this.state.documentTypes] : [];
    supportDocuments.map((doc)=>{
      //doc.id
      if(doc.mandatory){
        this.props.REMOVE_MANDATORY_LATEST('',doc.id,doc.mandatory,"", "");
      }

      //remove file
      var supportDocument= this.props.files ? [...this.props.files].find((file)=> file.code === doc.id) : [];

      if(supportDocument){
        if(supportDocument.files && supportDocument.files.length > 0)
          this.props.removeFile({isRequired:doc.mandatory, code:doc.id, name:supportDocument.files[0].name});
      }
    });
    this.setState({documentTypes : []});
  }

  tradeCategoryChangeAndResetFields = (field, value) =>{
    var tenantId = this.getTenantId();
    var _this=this;

    var values=value.split("~");
    var id = value.indexOf("~") > -1 ? values[0] : value;
    this.props.handleChange(id, field.code, field.isMandatory, "", "");
    if(values.length > 1){
      if(field.hasOwnProperty("codeName")){
        this.props.handleChange(values[1], field.codeName, false, "", "");
      }
    }

    const dropdownDataSource = {...this.state.dropdownDataSource, subCategoryId:[]}
    this.setState({dropdownDataSource, openDocClearDialog:false});
    this.props.handleChange("", "subCategoryId", field.isMandatory, "", "");
    this.props.handleChange("", "validityYears", field.isMandatory, "", "");
    this.props.handleChange("", "uomId", field.isMandatory, "", "");
    this.props.handleChange("", "uom", field.isMandatory, "", "");
    this.clearSupportDocuments();
    Api.commonApiPost("tl-masters/category/v1/_search",{type:"subcategory", active:true, categoryId:id},{tenantId:tenantId}, false, true).then(function(response){
      const dropdownDataSource = {..._this.state.dropdownDataSource, subCategoryId:sortArrayByAlphabetically(response.categories, "name")};
      _this.setState({dropdownDataSource});
    }, function(err) {
        console.log(err);
    });
  }

  tradeSubCategoryChangeAndResetFields = (field, value) =>{
    var tenantId = this.getTenantId();
    var _this=this;

    var values=value.split("~");
    var id = value.indexOf("~") > -1 ? values[0] : value;
    this.props.handleChange(id, field.code, field.isMandatory, "", "");
    if(values.length > 1){
      if(field.hasOwnProperty("codeName")){
        this.props.handleChange(values[1], field.codeName, false, "", "");
      }
    }

    this.setState({openDocClearDialog:false});
    // /tl-masters/category/v1/_search
    this.props.handleChange("", "validityYears", field.isMandatory, "", "");
    this.props.handleChange("", "uomId", field.isMandatory, "", "");
    this.props.handleChange("", "uom", field.isMandatory, "", "");
    this.clearSupportDocuments();

    Api.commonApiPost("tl-masters/category/v1/_search",{type:"subcategory", ids:id},{tenantId:tenantId}, false, true).then(function(response){
      var category=response.categories[0];
      _this.props.handleChange(category.validityYears, "validityYears", field.isMandatory, "", "");
      _this.props.handleChange(category.details[0].uomId, "uomId", field.isMandatory, "", "");
      _this.props.handleChange(category.details[0].uomName, "uom", false, "", "");
      _this.getDocuments();
    }, function(err) {
        console.log(err);
    });

  }

  getTenantId = ()=>{
    return localStorage.getItem("tenantId") || "default";
  }

  customHandleChange = (value, field) => {
    var tenantId = this.getTenantId();
    var _this=this;

    if(field.type === "dropdown"){

      if(field.code === "categoryId" || field.code === "subCategoryId"){

        // this.state.documentTypes.length > 0 && this.state.documentTypes.map((obj) => {
        //   obj.mandatory ? _this.props.REMOVE_MANDATORY_LATEST('', obj.id, obj.mandatory, "", "") : '';
        // });

        var files = this.props.files ? this.props.files.filter((field)=> field.files.length > 0) : undefined;
        if(files && files.length > 0){
          this.setState({confirmCategoryField:field, confirmCategoryFieldValue:value, openDocClearDialog:true});
        }
        else{
          if(field.code==='categoryId')
            this.tradeCategoryChangeAndResetFields(field, value);
          else
            this.tradeSubCategoryChangeAndResetFields(field, value);
        }
      }
      else{

        var values=value.split("~");
        var id = value.indexOf("~") > -1 ? values[0] : value;
        this.props.handleChange(id, field.code, field.isMandatory, "", "");
        if(values.length > 1){
          if(field.hasOwnProperty("codeName")){
            this.props.handleChange(values[1], field.codeName, false, "", "");
          }
        }

      }

    }
    else{

      //date field slash append functionality
      if(field.type == 'date'){
        var oldValue = this.props.form[field.code] || "";
        if((value.length === 2 || value.length === 5) && value.length > oldValue.length)
          value=value+"/";
      }

      this.props.handleChange(value, field.code, field.isMandatory || false, field.pattern || "", field.errorMsg || "");
      if(field.code === 'isPropertyOwner'){
        this.setState({isPropertyOwner:!value});
        var agreementdate = agreementDetailsSection.find(agreement => agreement.code == 'agreementDate');
        var agreementno = agreementDetailsSection.find(agreement => agreement.code == 'agreementNo');
        if(value){
          _this.props.ADD_MANDATORY_LATEST('','agreementDate',agreementdate.isMandatory,agreementdate.pattern,agreementdate.errorMsg);
          _this.props.ADD_MANDATORY_LATEST('','agreementNo',agreementno.isMandatory,agreementno.pattern);
        }else{
          //clear the values
          _this.props.handleChange('', 'agreementDate', false, "", "");
          _this.props.handleChange('', 'agreementNo', false, "", "");
          _this.props.REMOVE_MANDATORY_LATEST('','agreementDate',agreementdate.isMandatory,agreementdate.pattern,agreementdate.errorMsg);
          _this.props.REMOVE_MANDATORY_LATEST('','agreementNo',agreementno.isMandatory,agreementno.pattern);
        }
      }
    }

  }

  getDocuments = () => {
    var _this = this;
    let {form} = this.props;
    Api.commonApiPost("tl-masters/documenttype/v2/_search",{applicationType:"NEW", enabled:true, fallback:true, categoryId:form.categoryId, subCategoryId : form.subCategoryId},{}, false, true).then(function(response){
      _this.setState({documentTypes : sortArrayByAlphabetically(response.documentTypes,"name")},
        _this.addMandatoryDocuments(response.documentTypes)
      );
    }, function(err) {
        console.log(err);
    });
  }

  addMandatoryDocuments = (docTypes) => {
    var _this = this;
    docTypes.filter(function(obj){
      obj.mandatory ? _this.props.ADD_MANDATORY_LATEST('', obj.id, obj.mandatory, "", "") : '';
    })
  }

  customAutoCompleteKeyUpEvent = (e, field) =>{

    var _this=this;
    //reset autocomplete value
    this.props.handleChange("", field.code, field.isMandatory, field.pattern, field.errorMsg || "");

    if(e.target.value && field.code === 'localityId'){
      Api.commonApiGet("/egov-location/boundarys/getLocationByLocationName", {locationName : e.target.value}).then(function(response)
      {
        const autocompleteDataSource  = _this.state.autocompleteDataSource;
        autocompleteDataSource[field.code]=response;
        _this.setState({autocompleteDataSource});
      },function(err) {
        _this.handleError(err.message);
      });
    }

  }

  submit = (e) => {
    var _this=this;
    let {setLoadingStatus} = this.props;
    setLoadingStatus('loading');

    Api.commonApiPost( '/hr-employee/employees/_search', {id:localStorage.getItem('id')}).then((response)=>{
        let assignee;
        for(var i=0;i<response.Employee.length;i++){
          for(var j=0;j<response.Employee[i].assignments.length;j++){
            if(response.Employee[i].assignments[j].isPrimary){
                _this.renderObjToCreate(response.Employee[i].assignments[j].position);
                return;
            }
          }
        }
    },function(err) {
      setLoadingStatus('hide');
      _this.props.handleError(err.message);
    });
  }

  renderObjToCreate = (assignee) => {
    var _this=this;
    let {form, files, setLoadingStatus} = this.props;
    var licenseObj = {}, licenseArray = [];
    licenseObj = {...form};
    //adding optional fields value as undefined
    licenseObj['adhaarNumber'] = licenseObj['adhaarNumber'] || null;
    licenseObj['propertyAssesmentNo'] = licenseObj['propertyAssesmentNo'] || null;

    licenseObj['tenantId'] = localStorage.getItem('tenantId');
    licenseObj['applicationType'] = 'NEW';
    licenseObj['tradeCommencementDate'] = dateToEpoch(licenseObj.tradeCommencementDate);
    licenseObj['licenseValidFromDate'] = licenseObj.tradeCommencementDate;
    //isnotpropertyowner
    licenseObj['isPropertyOwner'] = licenseObj['isPropertyOwner'] ? licenseObj['isPropertyOwner'] : false;
    licenseObj['agreementDate'] = licenseObj.agreementDate ? dateToEpoch(licenseObj.agreementDate) : '';
    licenseObj['agreementNo'] = licenseObj.agreementNo ? licenseObj.agreementNo : '';
    licenseObj['isLegacy'] = false;
    licenseObj['active'] = true;
    licenseObj['application'] = {};
    licenseObj['application']['tenantId'] = localStorage.getItem('tenantId');
    licenseObj['application']['applicationType'] = 'NEW';
    licenseObj['application']['status'] = 4;
    licenseObj['application']['applicationDate'] = '';
    licenseObj['application']['licenseId'] = 0;
    licenseObj['application']['licenseFee'] = 0;
    licenseObj['application']['fieldInspectionReport'] = '';
    licenseObj['application']['statusName'] = 'Acknowledged';
    licenseObj['application']['workFlowDetails'] = {};
    licenseObj['application']['workFlowDetails']['department'] = null;
    licenseObj['application']['workFlowDetails']['designation'] = null;
    licenseObj['application']['workFlowDetails']['assignee'] = assignee;
    licenseObj['application']['workFlowDetails']['action'] = 'create';
    licenseObj['application']['workFlowDetails']['status  '] = "Pending For Application processing";
    licenseObj['application']['workFlowDetails']['comments'] = '';
    let userRequest = JSON.parse(localStorage.getItem('userRequest'));
    licenseObj['application']['workFlowDetails']['senderName'] = userRequest.name;
    licenseObj['application']['workFlowDetails']['details'] = '';
    licenseObj['application']['workFlowDetails']['stateId'] = null;
    licenseObj['supportDocuments'] = [];

    var supportDocuments = [];

    //filter which file field has files
    var supportingDocuments = files ? files.filter((field) => field.files.length > 0) : [];

    if(supportingDocuments && supportingDocuments.length > 0){
      let formData = new FormData();
      formData.append("tenantId", localStorage.getItem('tenantId'));
      formData.append("module", constants.TRADE_LICENSE_FILE_TAG);
      supportingDocuments.map((field, index) => {
          field.files.map((file)=>{
            formData.append("file", file);
          });
      });
      Api.commonApiPost("/filestore/v1/files",{},formData).then(function(response)
      {
        // console.log(response.files);
        response.files.map((file, index) => {
          let doc = supportingDocuments[index];
          let docs = {};
          docs['documentTypeId']=doc.code;
          docs['fileStoreId']=file.fileStoreId;
          docs['comments']=form[doc.code+'_comments'];
          docs['auditDetails']=doc.auditDetails;
          docs['documentTypeName']=doc.name;
          supportDocuments.push(docs);
        });

        licenseObj['supportDocuments'] = supportDocuments;
        licenseArray.push(licenseObj);
        _this.createTL(licenseArray);

      },function(err) {
        setLoadingStatus('hide');
        _this.handleError(err.message);
      });
    }else{
      licenseArray.push(licenseObj);
      _this.createTL(licenseArray);
    }
  }

  createTL = (licenseArray) => {
    var _this = this;
    let {setLoadingStatus} = this.props;
    Api.commonApiPost("tl-services/license/v1/_create",{},{licenses:licenseArray}, false, true).then(function(response){
      _this.getLatestLicense(response.licenses[0].id);
    }, function(err) {
        setLoadingStatus('hide');
        _this.handleError(err.message);
    });
  }

  getLatestLicense = (id) => {
    var self = this;
    let {setLoadingStatus} = this.props;
    let {handleError} = this;
    //set timeout
    setTimeout(function(){
      Api.commonApiPost("/tl-services/license/v1/_search",{ids : id}, {}, false, true).then(function(response)
      {
        if(response.licenses.length > 0){
          self.setState({
            showAck:true,
            licenseResponse : response.licenses[0],
          },setLoadingStatus('hide'));
        }else{
          setLoadingStatus('hide');
          handleError(translate('tl.view.license.notexist'));
        }
      },function(err) {
        setLoadingStatus('hide');
        handleError(err.message);
      });
    }, 3000);
  }

  handleError = (msg) => {
    let {toggleDailogAndSetText, toggleSnackbarAndSetText}=this.props;
    toggleDailogAndSetText(true, msg);
  }

  render(){
    let {setLoadingStatus, setRoute} = this.props;
    const supportDocClearActions = [
      <FlatButton
        label={translate('tl.confirm.title')}
        primary={true}
        keyboardFocused={true}
        onClick={this.handleDocumentsClearConfirm}
      />,
      <FlatButton
        label={translate('core.lbl.cancel')}
        primary={true}
        keyboardFocused={true}
        onClick={this.handleDocumentsClearCancel}
      />
    ];

    var agreementCard=null;
    var brElement=null;

    let {isFormValid} = this.props;

    if(!this.state["isPropertyOwner"]){
      // console.log('coming inside');
      agreementCard=<NewCard title={translate('tl.create.licenses.groups.agreementDetails')} form={this.props.form}
        fields={agreementDetailsSection}
        fieldErrors = {this.props.fieldErrors}
        handleChange={this.customHandleChange}></NewCard>;
      brElement=<br/>;
    }

    if(this.state.showAck){
      return(
        <Acknowledgement license={this.state.licenseResponse}
          handleError={this.handleError}
          setLoadingStatus={setLoadingStatus}
          setRoute={setRoute}
        />
      )
    }

    return(
      <div>
        <h2 className="application-title">{translate('tl.create.trade.title')}</h2>
        <NewCard title={translate('tl.create.licenses.groups.TradeOwnerDetails')} form={this.props.form}
          fields={tradeOwnerDetailsCardFields}
          fieldErrors = {this.props.fieldErrors}
          handleChange={this.customHandleChange}></NewCard>
        <br/>
        <NewCard title={translate('tl.create.licenses.groups.TradeLocationDetails')} form={this.props.form}
            fields={tradeLocationDetails}
            fieldErrors = {this.props.fieldErrors}
            autocompleteDataSource={this.state.autocompleteDataSource}
            autoCompleteKeyUp = {this.customAutoCompleteKeyUpEvent}
            dropdownDataSource={this.state.dropdownDataSource}
            handleChange={this.customHandleChange}></NewCard>
        <br/>
        <NewCard title={translate('tl.create.licenses.groups.TradeDetails')} form={this.props.form}
            fields={tradeDetails}
            fieldErrors = {this.props.fieldErrors}
            dropdownDataSource={this.state.dropdownDataSource}
            handleChange={this.customHandleChange}></NewCard>
        <br/>

        {agreementCard}
        {brElement}

        {this.state.documentTypes && this.state.documentTypes.length > 0 ?
        <SupportingDocuments files={this.props.files} dialogOpener={this.props.toggleDailogAndSetText}
           title={translate('tl.table.title.supportDocuments')} docs={this.state.documentTypes}
           addFile={this.props.addFile} removeFile={this.props.removeFile}
           fileSectionChange={this.fileSectionChange}>
        </SupportingDocuments> : ''}
        <br/>

        <Dialog
          actions={supportDocClearActions}
          modal={true}
          open={this.state.openDocClearDialog || false}>
            {this.state.supportDocClearDialogMsg}
        </Dialog>

     </div>
    )
  }
}