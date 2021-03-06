package org.egov.works.estimate.web.contract;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An Object which holds Schedule Of Rate Master Data. The combination of SOR code and Schedule Category is unique for given tenant.
 */
@ApiModel(description = "An Object which holds Schedule Of Rate Master Data. The combination of SOR code and Schedule Category is unique for given tenant.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-03T07:36:47.547Z")

public class ScheduleOfRate   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("scheduleCategory")
  private ScheduleCategory scheduleCategory = null;

  @JsonProperty("uom")
  private UOM uom = null;

  @JsonProperty("sorRates")
  private List<SORRate> sorRates = new ArrayList<SORRate>();

  @JsonProperty("marketRates")
  private List<MarketRate> marketRates = null;

  @JsonProperty("auditDetails")
  private AuditDetails auditDetails = null;

  public ScheduleOfRate id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier of the Schedule Of Rate
   * @return id
  **/
  @ApiModelProperty(value = "Unique Identifier of the Schedule Of Rate")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ScheduleOfRate tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Tenant id of the Schedule Of Rate
   * @return tenantId
  **/
  @ApiModelProperty(required = true, value = "Tenant id of the Schedule Of Rate")
  @NotNull

 @Size(min=4,max=128)
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public ScheduleOfRate code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Unique code of the Schedule Of Rate
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Unique code of the Schedule Of Rate")
  @NotNull

 @Pattern(regexp="[a-zA-Z0-9-\\\\]+") @Size(min=1,max=100)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ScheduleOfRate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the Schedule Of Rate
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the Schedule Of Rate")
  @NotNull

 @Pattern(regexp="[0-9a-zA-Z_@./#&+-/!(){}\",^$%*|=;:<>?`~ ]+") @Size(min=1,max=4000)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ScheduleOfRate scheduleCategory(ScheduleCategory scheduleCategory) {
    this.scheduleCategory = scheduleCategory;
    return this;
  }

   /**
   * Schedule Category of the SOR
   * @return scheduleCategory
  **/
  @ApiModelProperty(required = true, value = "Schedule Category of the SOR")
  @NotNull

  @Valid

  public ScheduleCategory getScheduleCategory() {
    return scheduleCategory;
  }

  public void setScheduleCategory(ScheduleCategory scheduleCategory) {
    this.scheduleCategory = scheduleCategory;
  }

  public ScheduleOfRate uom(UOM uom) {
    this.uom = uom;
    return this;
  }

   /**
   * Unit Of Measurement of the SOR
   * @return uom
  **/
  @ApiModelProperty(required = true, value = "Unit Of Measurement of the SOR")
  @NotNull

  @Valid

  public UOM getUom() {
    return uom;
  }

  public void setUom(UOM uom) {
    this.uom = uom;
  }

  public ScheduleOfRate sorRates(List<SORRate> sorRates) {
    this.sorRates = sorRates;
    return this;
  }

  public ScheduleOfRate addSorRatesItem(SORRate sorRatesItem) {
    this.sorRates.add(sorRatesItem);
    return this;
  }

   /**
   * Array of Rate Details.
   * @return sorRates
  **/
  @ApiModelProperty(required = true, value = "Array of Rate Details.")
  @NotNull

  @Valid

  public List<SORRate> getSorRates() {
    return sorRates;
  }

  public void setSorRates(List<SORRate> sorRates) {
    this.sorRates = sorRates;
  }

  public ScheduleOfRate marketRates(List<MarketRate> marketRates) {
    this.marketRates = marketRates;
    return this;
  }

  public ScheduleOfRate addMarketRatesItem(MarketRate marketRatesItem) {
    if (this.marketRates == null) {
      this.marketRates = new ArrayList<MarketRate>();
    }
    this.marketRates.add(marketRatesItem);
    return this;
  }

   /**
   * Array of Market Rate Details..
   * @return marketRates
  **/
  @ApiModelProperty(value = "Array of Market Rate Details..")

  @Valid

  public List<MarketRate> getMarketRates() {
    return marketRates;
  }

  public void setMarketRates(List<MarketRate> marketRates) {
    this.marketRates = marketRates;
  }

  public ScheduleOfRate auditDetails(AuditDetails auditDetails) {
    this.auditDetails = auditDetails;
    return this;
  }

   /**
   * Get auditDetails
   * @return auditDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AuditDetails getAuditDetails() {
    return auditDetails;
  }

  public void setAuditDetails(AuditDetails auditDetails) {
    this.auditDetails = auditDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleOfRate scheduleOfRate = (ScheduleOfRate) o;
    return Objects.equals(this.id, scheduleOfRate.id) &&
        Objects.equals(this.tenantId, scheduleOfRate.tenantId) &&
        Objects.equals(this.code, scheduleOfRate.code) &&
        Objects.equals(this.description, scheduleOfRate.description) &&
        Objects.equals(this.scheduleCategory, scheduleOfRate.scheduleCategory) &&
        Objects.equals(this.uom, scheduleOfRate.uom) &&
        Objects.equals(this.sorRates, scheduleOfRate.sorRates) &&
        Objects.equals(this.marketRates, scheduleOfRate.marketRates) &&
        Objects.equals(this.auditDetails, scheduleOfRate.auditDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, code, description, scheduleCategory, uom, sorRates, marketRates, auditDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleOfRate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    scheduleCategory: ").append(toIndentedString(scheduleCategory)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    sorRates: ").append(toIndentedString(sorRates)).append("\n");
    sb.append("    marketRates: ").append(toIndentedString(marketRates)).append("\n");
    sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

