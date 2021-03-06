package org.egov.works.estimate.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WorksEstimateServiceConstants {

    public static final String ABSTRACT_ESTIMATE_NUMBER_GENERATION_ERROR = "Abstract estimate numebr can not be generated";
    public static final String DETAILED_ESTIMATE_NUMBER_GENERATION_ERROR = "Detailed estimate numebr can not be generated";
    public static final String WORK_IDENTIFICATION_NUMBER_GENERATION_ERROR = "Work identification numebr can not be generated";

    public static final String TYPEOFWORK_OBJECT = "TypeOfWork";
    public static final String FUND_OBJECT = "Fund";
    public static final String FUNCTION_OBJECT = "Function";
    public static final String SUBTYPEOFWORK_OBJECT = "SubTypeOfWork";
    public static final String SCHEME_OBJECT = "Scheme";
    public static final String SUBSCHEME_OBJECT = "SubScheme";
    public static final String BUDGETGROUP_OBJECT = "BudgetGroup";
    public static final String DEPARTMENT_OBJECT = "Department";
    public static final String WORKS_MODULE_CODE = "Works";
    public static final String COMMON_MASTERS_MODULE_CODE = "common-masters";
    public static final String OVERHEAD_OBJECT = "Overhead";

    public static final String BOUNDARY_OBJECT = "Boundary";
    public static final String APPCONFIGURATION_OBJECT = "AppConfiguration";
    public static final String GIS_INTEGRATION_APPCONFIG = "GIS_INTEGRATION";
    public static final String ASSET_DETAILES_REQUIRED_APPCONFIG = "ASSET_MANDATORY";

    //Error messages
    public static final String KEY_ESIMATE_OVERHEAD_ID = "ESIMATE OVERHEAD_ID";
    public static final String MESSAGE_ESIMATE_OVERHEAD_ID = "Overhead id is reqired for estimate";

    public static final String KEY_ESIMATE_OVERHEAD_AMOUNT = "ESIMATE_OVERHEAD_AMOUNT";
    public static final String MESSAGE_ESIMATE_OVERHEAD_AMOUNT = "Overhead amount is required for estimate";

    public static final String KEY_DUPLICATE_MULTIYEAR_ESTIMATE = "DUPLICATE_MULTIYEAR_ESTIMATE";
    public static final String MESSAGE_DUPLICATE_MULTIYEAR_ESTIMATE = "Duplicate multiyear estimates";

    public static final String KEY_PERCENTAGE_MULTIYEAR_ESTIMATE = "INVALID_PERCANTAGE_MULTIYEAR_ESTIMATE";
    public static final String MESSAGE_PERCENTAGE_MULTIYEAR_ESTIMATE = "Percentage should not  be greater than 100 for multiyear estimates";

    public static final String KEY_NULL_DATEOFPROPOSAL = "INVALID_DATEOFPROPOSAL";
    public static final String MESSAGE_NULL_DATEOFPROPOSAL = "Date of proposal should be entered";

    public static final String KEY_FUTUREDATE_DATEOFPROPOSAL = "INVALID_DATEOFPROPOSAL";
    public static final String MESSAGE_FUTUREDATE_DATEOFPROPOSAL = "Date of proposal cannot be future date";
    
    public static final String KEY_NULL_TENANTID = "INVALID_TENANTID";
    public static final String MESSAGE_NULL_TENANTID = "Tenantid of should be entered";

    public static final String KEY_FUND_INVALID = "INVALID_FUND";
    public static final String MESSAGE_FUND_INVALID = "Plese provide valid data for fund";
    
    public static final String KEY_FUNCTION_INVALID = "INVALID_FUNCTION";
    public static final String MESSAGE_FUNCTION_INVALID = "Plese provide valid data for function";
    
    public static final String KEY_TYPEOFWORK_INVALID = "INVALID_TYPEOFWORK";
    public static final String MESSAGE_TYPEOFWORK_INVALID = "Plese provide valid data for Type Of Work";
    
    public static final String KEY_SUBTYPEOFWORK_INVALID = "INVALID_SUBTYPEOFWORK";
    public static final String MESSAGE_SUBTYPEOFWORK_INVALID = "Plese provide valid data for Sub Type Of Work";

    public static final String KEY_DEPARTMENT_INVALID = "INVALID_DEPARTMENT";
    public static final String MESSAGE_DEPARTMENT_INVALID = "Plese provide valid data for Department";
    
    public static final String KEY_SCHEME_INVALID = "INVALID_SCHEME";
    public static final String MESSAGE_SCHEME_INVALID = "Plese provide valid data for Scheme";

    public static final String KEY_SUBSCHEME_INVALID = "INVALID_SUBSCHEME";
    public static final String MESSAGE_SUBSCHEME_INVALID = "Plese provide valid data for Sub Scheme";

    public static final String KEY_BUDGETGROUP_INVALID = "INVALID_BUDGETGROUP";
    public static final String MESSAGE_BUDGETGROUP_INVALID = "Plese provide valid data for Budget Group";

    public static final String KEY_UNIQUE_ABSTRACTESTIMATENUMBER = "UNIQUE_ABSTRACTESTIMATENUMBER";
    public static final String MESSAGE_UNIQUE_ABSTRACTESTIMATENUMBER = "Abstract Estimate Number should be Unique";
    
    public static final String KEY_UNIQUE_ADMINSANCTIONNUMBER = "UNIQUE_ADMINSANCTIONNUMBER";
    public static final String MESSAGE_UNIQUE_ADMINSANCTIONNUMBER = "Admin Sanction Number should be Unique";

    public static final String KEY_UNIQUE_COUNCILRESOLUTIONNUMBER = "UNIQUE_COUNCILRESOLUTIONNUMBER";
    public static final String MESSAGE_UNIQUE_COUNCILRESOLUTIONNUMBER = "Council Resolution Number should be Unique";

    public static final String KEY_NULL_COUNCILRESOLUTIONDATE = "INVALID_COUNCILRESOLUTIONDATE";
    public static final String MESSAGE_NULL_COUNCILRESOLUTIONDATE = "Council Resolution Date should be entered";
    
    public static final String KEY_NULL_ADMINSANCTIONNUMBER = "UNIQUE_ADMINSANCTIONNUMBER";
    public static final String MESSAGE_NULL_ADMINSANCTIONNUMBER = "Admin Sanction Number should be entered";

    public static final String KEY_UNIQUE_ESTIMATENUMBER = "UNIQUE_ESTIMATENUMBER";
    public static final String MESSAGE_UNIQUE_ESTIMATENUMBER = "Estimate Number should be Unique";

    public static final String KEY_INVALID_ESTIMATEAMOUNT = "UNIQUE_ESTIMATEAMOUNT";
    public static final String MESSAGE_INVALID_ESTIMATEAMOUNT = "Estimate Amount should be greater then 0";
    
    public static final String KEY_UNIQUE_WORKIDENTIFICATIONNUMBER = "UNIQUE_WORKIDENTIFICATIONNUMBER";
    public static final String MESSAGE_UNIQUE_WORKIDENTIFICATIONNUMBER = "Work Identification Number should be entered";

    public static final String KEY_ESTIMATE_ACTIVITY_SCHEDULEOFRATE= "INVALID_ESTIMATE_ACTIVITY_SCHEDULEOFRATE";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_SCHEDULEOFRATE = "Duplicate data for activity schedule of rates";

    public static final String KEY_ESTIMATE_ACTIVITY_QUANTITY= "INVALID_ESTIMATE_ACTIVITY_QUANTITY";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_QUANTITY = "Activity quantity should be greater than zero";

    public static final String KEY_ESTIMATE_ACTIVITY_INVALID= "INVALID_ESTIMATE_ACTIVITY";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_INVALID = "Invalid data for estimate activity";

    public static final String KEY_ESTIMATE_ACTIVITY_REQUIRED= "ESTIMATE_ACTIVITY_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_REQUIRED = "Atleast one activity is required to create an estimate";

    public static final String KEY_ESTIMATE_ACTIVITY_ESTIMATE_RATE= "INVALID_ESTIMATE_ACTIVITY_ESTIMATE_RATE";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_ESTIMATE_RATE = "Activity estimate rate should be greater than zero";

    public static final String KEY_ESTIMATE_LOCATION_REQUIRED= "INVALID_ESTIMATE_LOCATION";
    public static final String MESSAGE_ESTIMATE_LOCATION_REQUIRED= "Estimate location detailed required";

    public static final String KEY_ESTIMATE_ASSET_DETAILS_REQUIRED= "INVALID_ESTIMATE_ASSET_DETAILES";
    public static final String MESSAGE_ESTIMATE_ASSET_DETAILS_REQUIRED= "Asset detailes required for an estimate";

    public static final String KEY_DUPLICATE_ESTIMATE_ASSET_DETAILS= "DUPLICATE_ESTIMATE_ASSET_DETAILES";
    public static final String MESSAGE_DUPLICATE_ESTIMATE_ASSET_DETAILS= "Duplicate Asset detailes for an estimate";

    public static final String KEY_ESTIMATE_FUND_CODE_INVALID= "ESTIMATE_FUND_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_FUND_CODE_INVALID= "Invalid data for esimate fund code";

    public static final String KEY_ESTIMATE_FUNCTION_CODE_INVALID= "ESTIMATE_FUNCTION_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_FUNCTION_CODE_INVALID= "Invalid data for esimate function code";

    public static final String KEY_ESTIMATE_TYPEOFWORK_CODE_INVALID= "ESTIMATE_TYPEOFWORK_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_TYPEOFWORK_CODE_INVALID= "Invalid data for esimate type of work code";

    public static final String KEY_ESTIMATE_SUBTYPEOFWORK_CODE_INVALID= "ESTIMATE_SUBTYPEOFWORK_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_SUBTYPEOFWORK_CODE_INVALID= "Invalid data for esimate subtype of work code";

    public static final String KEY_ESTIMATE_SCHEME_CODE_INVALID= "ESTIMATE_SCHEME_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_SCHEME_CODE_INVALID= "Invalid data for esimate scheme";

    public static final String KEY_ESTIMATE_SUBSCHEME_CODE_INVALID= "ESTIMATE_SUBSCHEME_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_SUBSCHEME_CODE_INVALID= "Invalid data for esimate subscheme";

    public static final String KEY_ESTIMATE_DEPARTMENT_CODE_INVALID= "ESTIMATE_DEPARTMENT_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_DEPARTMENT_CODE_INVALID= "Invalid data for esimate department";

    public static final String KEY_ESTIMATE_BUDGETGROUP_INVALID= "ESTIMATE_BUDGETGROUP_INVALID";
    public static final String MESSAGE_ESTIMATE_BUDGETGROUP_INVALID= "Invalid data for esimate budget group";

    public static final String KEY_ESTIMATE_OVERHEAD_CODE_INVALID= "ESTIMATE_OVERHEAD_INVALID";
    public static final String MESSAGE_ESTIMATE_OVERHEAD_CODE_INVALID= "Invalid data for esimate overhead code";

    public static final String KEY_ESTIMATE_ASSET_REQUIRED= "ESTIMATE_ASSET_CODE_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ASSET_REQUIRED= "Invalid data for esimate asset code";

    public static final String KEY_ESTIMATE_ACTIVITY_ESTIMATE_RATE_REQUIRED= "ESTIMATE_ACTIVITY_ESTIMATE_RATE_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_ESTIMATE_RATE_REQUIRED= "Estimate rate is required for activity";

    public static final String KEY_ESTIMATE_ACTIVITY_UOM_REQUIRED= "ESTIMATE_ACTIVITY_UOM_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_UOM_REQUIRED= "UOM is required for activity";

    public static final String KEY_ESTIMATE_ACTIVITY_UOM_CODE_INVALID= "ESTIMATE_ACTIVITY_UOM_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_UOM_CODE_INVALID= "Invalid data for UOM code";

    public static final String KEY_ESTIMATE_ACTIVITY_UNIT_RATE_REQUIRED= "ESTIMATE_ACTIVITY_UNIT_RATE_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_UNIT_RATE_REQUIRED= "Unit rate is required for an estimate";

    public static final String KEY_ESTIMATE_ACTIVITY_UNIT_RATE_INVALID= "ESTIMATE_ACTIVITY_UNIT_RATE_INVALID";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_UNIT_RATE_INVALID= "Unit rate should be grater than zero";

    public static final String KEY_ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_REQUIRED= "ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_REQUIRED";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_REQUIRED= "Estimate measurement sheet quantity is required";

    public static final String KEY_ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_INVALID= "ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_INVALID";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_MEASUREMENT_QUANTITY_INVALID= "Estimate measurement sheet quantity should be greater than zero";

    public static final String KEY_ESTIMATE_ACTIVITY_SCHEDULEOFRATE_CODE_INVALID= "ESTIMATE_ACTIVITY_SCHEDULEOFRATE_CODE_INVALID";
    public static final String MESSAGE_ESTIMATE_ACTIVITY_SCHEDULEOFRATE_CODE_INVALID= "Estimate activity schedule of rate code invalid";

    public static final String KEY_WORKS_ESTIMATE_ASSET_CODE_INVALID= "WORKS_ESTIMATE_ASSET_CODE_INVALID";
    public static final String MESSAGE_WORKS_ESTIMATE_ASSET_CODE_INVALID= "Invalid data for estimate asset code";



}
