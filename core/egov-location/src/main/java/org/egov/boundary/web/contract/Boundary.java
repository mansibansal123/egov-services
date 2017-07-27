package org.egov.boundary.web.contract;

import java.util.List;

import org.egov.boundary.persistence.entity.BoundaryType;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Boundary {

	@NotEmpty
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("boundaryIds")
	private List<Long> boundaryIds;

	@JsonProperty("name")
	private String name;

	@JsonProperty("longitude")
	private Float longitude;

	@JsonProperty("latitude")
	private Float latitude;

	@JsonProperty("boundaryNum")
	private Long boundaryNum;

	@JsonProperty("parent")
	private Boundary parent;

	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("boundaryType")
	private BoundaryType boundaryType;

	public Boundary(org.egov.boundary.persistence.entity.Boundary entityBoundary) {
		this.id = entityBoundary.getId() != null ? entityBoundary.getId().toString() : null;
		this.name = entityBoundary.getName();
		if (entityBoundary.getParent() != null) {
			this.setParent(new Boundary(entityBoundary.getParent()));
		}
		this.longitude = entityBoundary.getLongitude();
		this.latitude = entityBoundary.getLatitude();
		this.boundaryNum = entityBoundary.getBoundaryNum();
		this.tenantId = entityBoundary.getTenantId();
		this.boundaryType = entityBoundary.getBoundaryType();
	}

}