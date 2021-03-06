package org.egov.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * All APIs will return ErrorRes in case of failure which will carry
 * ResponseInfo as metadata and Error object as actual representation of error.
 * In case of bulk apis, some apis may chose to return the array of Error
 * objects to indicate individual failure. Author : Narendra
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRes {
	@JsonProperty("ResponseInfo")
	@SerializedName("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("Errors")
	@SerializedName("Errors")
	private List<Error> errors = new ArrayList<Error>();
}
