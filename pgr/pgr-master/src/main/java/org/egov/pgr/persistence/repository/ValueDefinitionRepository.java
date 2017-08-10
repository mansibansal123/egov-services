package org.egov.pgr.persistence.repository;

import org.egov.pgr.persistence.dto.AttributeDefinition;
import org.egov.pgr.persistence.dto.ServiceType;
import org.egov.pgr.persistence.dto.ValueDefinition;
import org.egov.pgr.persistence.querybuilder.ValueDefinitionQueryBuilder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ValueDefinitionRepository {

    private ValueDefinitionQueryBuilder valueDefinitionQueryBuilder;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ValueDefinitionRepository(ValueDefinitionQueryBuilder valueDefinitionQueryBuilder,
                                     NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.valueDefinitionQueryBuilder = valueDefinitionQueryBuilder;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(ValueDefinition valueDefinition){
        namedParameterJdbcTemplate.update(valueDefinitionQueryBuilder.getInsertQuery(),
                getInsertMap(valueDefinition));
    }

    public void setValueDefinition(ServiceType serviceType){

        serviceType.getAttributeDefinitions().stream()
                .filter(AttributeDefinition::isValueList)
                .forEach(Attribute -> Attribute.setValueDefinitions(
                        fetchValueDefinition(serviceType.getCode(),serviceType.getTenantId(), Attribute.getCode())));
    }

    private List<ValueDefinition> fetchValueDefinition(String code, String tenantId, String attributeCode){

      return  namedParameterJdbcTemplate.query(valueDefinitionQueryBuilder.findByTenantIdAndServiceCodeAndAttributeCode(),
                getValueDefinitionMap(code, tenantId, attributeCode),
                new BeanPropertyRowMapper<>(ValueDefinition.class));
    }

    private HashMap getInsertMap(ValueDefinition valueDefinition){
        HashMap<String, Object> parametersMap = new HashMap<>();

        parametersMap.put("servicecode", valueDefinition.getServiceCode());
        parametersMap.put("tenantid", valueDefinition.getTenantId());
        parametersMap.put("active", valueDefinition.getActive());
        parametersMap.put("key", valueDefinition.getKey());
        parametersMap.put("name", valueDefinition.getName());
        parametersMap.put("attributecode", valueDefinition.getAttributeCode());
        parametersMap.put("createddate", valueDefinition.getCreatedDate());
        parametersMap.put("createdby", valueDefinition.getCreatedBy());

        return parametersMap;
    }

    private HashMap<String, Object> getValueDefinitionMap(String code, String tenantId, String attributeCode){
        HashMap<String, Object> parametersMap = new HashMap<>();
        parametersMap.put("servicecode", code);
        parametersMap.put("tenantid", tenantId);
        parametersMap.put("attributecode", attributeCode);

        return parametersMap;
    }
}
