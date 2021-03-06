package org.egov.works.estimate.web.contract;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An Object holds the basic data of Estimate Overheads
 */
@ApiModel(description = "An Object holds the basic data of Estimate Overheads")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-03T07:36:47.547Z")

public class EstimateOverhead   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("overhead")
  private Overhead overhead = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("detailedEstimate")
  private DetailedEstimate detailedEstimate = null;

  @JsonProperty("auditDetails")
  private AuditDetails auditDetails = null;

  public EstimateOverhead id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier of the Estimate Overheads
   * @return id
  **/
  @ApiModelProperty(value = "Unique Identifier of the Estimate Overheads")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EstimateOverhead tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Tenant id of the Estimate Overheads
   * @return tenantId
  **/
  @ApiModelProperty(required = true, value = "Tenant id of the Estimate Overheads")
  @NotNull

 @Size(min=4,max=128)
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public EstimateOverhead overhead(Overhead overhead) {
    this.overhead = overhead;
    return this;
  }

   /**
   * Get overhead
   * @return overhead
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Overhead getOverhead() {
    return overhead;
  }

  public void setOverhead(Overhead overhead) {
    this.overhead = overhead;
  }

  public EstimateOverhead amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Overhead amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Overhead amount")
  @NotNull

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public EstimateOverhead detailedEstimate(DetailedEstimate detailedEstimate) {
    this.detailedEstimate = detailedEstimate;
    return this;
  }

   /**
   * Reference of the Detailed Estimate for Overheads
   * @return detailedEstimate
  **/
  @ApiModelProperty(required = true, value = "Reference of the Detailed Estimate for Overheads")
  //@NotNull

  @Valid

  public DetailedEstimate getDetailedEstimate() {
    return detailedEstimate;
  }

  public void setDetailedEstimate(DetailedEstimate detailedEstimate) {
    this.detailedEstimate = detailedEstimate;
  }

  public EstimateOverhead auditDetails(AuditDetails auditDetails) {
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
    EstimateOverhead estimateOverhead = (EstimateOverhead) o;
    return Objects.equals(this.id, estimateOverhead.id) &&
        Objects.equals(this.tenantId, estimateOverhead.tenantId) &&
        Objects.equals(this.overhead, estimateOverhead.overhead) &&
        Objects.equals(this.amount, estimateOverhead.amount) &&
        Objects.equals(this.detailedEstimate, estimateOverhead.detailedEstimate) &&
        Objects.equals(this.auditDetails, estimateOverhead.auditDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, overhead, amount, detailedEstimate, auditDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstimateOverhead {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    overhead: ").append(toIndentedString(overhead)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    detailedEstimate: ").append(toIndentedString(detailedEstimate)).append("\n");
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

