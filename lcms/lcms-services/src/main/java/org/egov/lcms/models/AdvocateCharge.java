package org.egov.lcms.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvocateCharge   {
 
	
  @JsonProperty("charge")
  private String charge = null;

  @JsonProperty("caseNo")
  private String caseNo = null;

  @JsonProperty("amount")
  private Double amount = null;

 
}

