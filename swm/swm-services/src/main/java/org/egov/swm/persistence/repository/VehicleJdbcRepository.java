package org.egov.swm.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.swm.domain.model.Pagination;
import org.egov.swm.domain.model.Vehicle;
import org.egov.swm.domain.model.VehicleSearch;
import org.egov.swm.persistence.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class VehicleJdbcRepository extends JdbcRepository {

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Boolean uniqueCheck(String tenantId, String fieldName, String fieldValue, String uniqueFieldName,
			String uniqueFieldValue) {

		return uniqueCheck("egswm_vehicle", tenantId, fieldName, fieldValue, uniqueFieldName, uniqueFieldValue);
	}

	public Pagination<Vehicle> search(VehicleSearch searchRequest) {

		String searchQuery = "select * from egswm_vehicle :condition  :orderby ";

		Map<String, Object> paramValues = new HashMap<>();
		StringBuffer params = new StringBuffer();

		if (searchRequest.getSortBy() != null && !searchRequest.getSortBy().isEmpty()) {
			validateSortByOrder(searchRequest.getSortBy());
			validateEntityFieldName(searchRequest.getSortBy(), VehicleSearch.class);
		}

		String orderBy = "order by regNumber";
		if (searchRequest.getSortBy() != null && !searchRequest.getSortBy().isEmpty()) {
			orderBy = "order by " + searchRequest.getSortBy();
		}

		if (searchRequest.getTenantId() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("tenantId =:tenantId");
			paramValues.put("tenantId", searchRequest.getTenantId());
		}
		if (searchRequest.getRegNumber() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("regNumber =:regNumber");
			paramValues.put("regNumber", searchRequest.getRegNumber());
		}
		if (searchRequest.getManufacturingDetails() != null) {

			if (searchRequest.getManufacturingDetails().getChassisSrNumber() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("chassisSrNumber =:chassisSrNumber");
				paramValues.put("chassisSrNumber", searchRequest.getManufacturingDetails().getChassisSrNumber());
			}

			if (searchRequest.getManufacturingDetails().getEngineSrNumber() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("engineSrNumber =:engineSrNumber");
				paramValues.put("engineSrNumber", searchRequest.getManufacturingDetails().getEngineSrNumber());
			}

			if (searchRequest.getInsuranceDetails().getInsuranceNumber() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("insuranceNumber =:insuranceNumber");
				paramValues.put("insuranceNumber", searchRequest.getInsuranceDetails().getInsuranceNumber());
			}

			if (searchRequest.getManufacturingDetails().getModel() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("model =:model");
				paramValues.put("model", searchRequest.getManufacturingDetails().getModel());
			}

		}

		if (searchRequest.getInsuranceDetails() != null) {
			if (searchRequest.getInsuranceDetails().getInsuranceValidityDate() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("insuranceValidityDate =:insuranceValidityDate");
				paramValues.put("insuranceValidityDate",
						searchRequest.getInsuranceDetails().getInsuranceValidityDate());
			}
		}

		if (searchRequest.getPurchaseInfo() != null) {

			if (searchRequest.getPurchaseInfo().getPurchaseDate() != null) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append("purchaseDate =:purchaseDate");
				paramValues.put("purchaseDate", searchRequest.getPurchaseInfo().getPurchaseDate());
			}

		}

		if (searchRequest.getVehicleTypeCode() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("vehicleType =:vehicleType");
			paramValues.put("vehicleType", searchRequest.getVehicleTypeCode());
		}

		if (searchRequest.getFuelTypeCode() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("fuelType =:fuelType");
			paramValues.put("fuelType", searchRequest.getFuelTypeCode());
		}

		if (searchRequest.getPurchaseYear() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("yearOfPurchase =:yearOfPurchase");
			paramValues.put("yearOfPurchase", searchRequest.getPurchaseYear());
		}

		if (searchRequest.getVendorName() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("vendor =:vendor");
			paramValues.put("vendor", searchRequest.getVendorName());
		}

		Pagination<Vehicle> page = new Pagination<>();
		if (searchRequest.getOffset() != null) {
			page.setOffset(searchRequest.getOffset());
		}
		if (searchRequest.getPageSize() != null) {
			page.setPageSize(searchRequest.getPageSize());
		}

		if (params.length() > 0) {

			searchQuery = searchQuery.replace(":condition", " where " + params.toString());

		} else

			searchQuery = searchQuery.replace(":condition", "");

		searchQuery = searchQuery.replace(":orderby", orderBy);

		page = (Pagination

		<Vehicle>) getPagination(searchQuery, page, paramValues);
		searchQuery = searchQuery + " :pagination";

		searchQuery = searchQuery.replace(":pagination",
				"limit " + page.getPageSize() + " offset " + page.getOffset() * page.getPageSize());

		BeanPropertyRowMapper row = new BeanPropertyRowMapper(VehicleEntity.class);

		List<Vehicle> vehicleList = new ArrayList<>();

		List<VehicleEntity> vehicleEntities = namedParameterJdbcTemplate.query(searchQuery.toString(), paramValues,
				row);

		for (VehicleEntity vehicleEntity : vehicleEntities) {

			vehicleList.add(vehicleEntity.toDomain());
		}

		page.setTotalResults(vehicleList.size());

		page.setPagedData(vehicleList);

		return page;
	}

}