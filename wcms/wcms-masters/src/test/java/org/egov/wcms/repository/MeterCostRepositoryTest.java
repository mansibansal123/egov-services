package org.egov.wcms.repository;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.tracer.kafka.LogAwareKafkaTemplate;
import org.egov.wcms.config.ApplicationProperties;
import org.egov.wcms.model.MeterCostCriteria;
import org.egov.wcms.model.MeterCost;
import org.egov.wcms.repository.builder.MeterCostQueryBuilder;
import org.egov.wcms.repository.rowmapper.MeterCostRowMapper;
import org.egov.wcms.web.contract.MeterCostReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class MeterCostRepositoryTest {
	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private LogAwareKafkaTemplate<String, Object> kafkaTemplate;

	@Mock
	private ApplicationProperties applicationProperties;

	@Mock
	private MeterCostQueryBuilder meterCostQueryBuilder;

	@Mock
	private MeterCostRowMapper meterCostRowMapper;

	@InjectMocks
	private MeterCostRepository meterCostRepository;

	@Test
	public void test_should_push_create_meterCostRequest_to_Queue() {
		when(applicationProperties.getCreateMeterCostTopicName()).thenReturn("egov.wcms.metercost-create");
		meterCostRepository.pushCreateMeterCostReqToQueue(getMeterCostRequest());
		verify(kafkaTemplate).send("egov.wcms.metercost-create", getMeterCostRequest());
	}

	@Test
	public void test_should_push_update_meterCostRequest_to_Queue() {
		when(applicationProperties.getUpdateMeterCostTopicName()).thenReturn("egov.wcms.metercost-update");
		meterCostRepository.pushUpdateMeterCostReqToQueue(getMeterCostRequestForUpdate());
		verify(kafkaTemplate).send("egov.wcms.metercost-update", getMeterCostRequestForUpdate());
	}

	@Test
	public void test_should_persist_create_meterCost_to_DB() {
		when(meterCostQueryBuilder.insertMeterCostQuery()).thenReturn(
				"INSERT INTO egwtr_metercost(id,code,pipesizeid,metermake,amount,active,createdby,lastmodifiedby,createddate,"
						+ "lastmodifieddate,tenantid) values " + "(?,?,?,?,?,?,?,?,?,?,?)");
		when(jdbcTemplate.queryForObject("SELECT nextval('" + "seq_egwtr_meter_cost" + "')", Long.class)).thenReturn(1L,
				2L);
		meterCostRepository.persistCreateMeterCost(getMeterCostRequest());
		verify(jdbcTemplate).batchUpdate(
				eq("INSERT INTO egwtr_metercost(id,code,pipesizeid,metermake,amount,active,createdby,lastmodifiedby,createddate,"
						+ "lastmodifieddate,tenantid) values " + "(?,?,?,?,?,?,?,?,?,?,?)"),
				any(List.class));
	}

	@Test
	public void test_should_update_meterCost_to_DB() {
		when(meterCostQueryBuilder.updateMeterCostQuery())
				.thenReturn("Update egwtr_metercost set pipesizeid=?, metermake=?, amount=?, active=?,"
						+ " lastmodifiedby=?, lastmodifieddate=? where code = ? and tenantId = ?");
		meterCostRepository.persistUpdateMeterCost(getMeterCostRequestForUpdate());
		verify(jdbcTemplate)
				.batchUpdate(
						eq("Update egwtr_metercost set pipesizeid=?, metermake=?, amount=?, active=?,"
								+ " lastmodifiedby=?, lastmodifieddate=? where code = ? and tenantId = ?"),
						any(List.class));
	}

	@Test
	public void test_should_search_meterCost_from_DB() {
		List<Object> preparedStatementValues = new ArrayList<>();
		when(meterCostQueryBuilder.getQuery(getMeterCostCriteria(), preparedStatementValues))
				.thenReturn("Select wmc.id as wmc_id,wmc.code as wmc_code,"
						+ "wmc.pipesizeid as wmc_pipesizeid,wmc.metermake as wmc_metermake,wmc.amount as wmc_amount,"
						+ "wmc.active as wmc_active,wmc.createdby as wmc_createdby,wmc.createddate as wmc_createddate,"
						+ "wmc.lastmodifiedby as wmc_lastmodifiedby,wmc.lastmodifieddate as wmc_lastmodifieddate,"
						+ "wmc.tenantid as wmc_tenantid from egwtr_metercost wmc WHERE wmc.tenantId = ? AND "
						+ "wmc.active = ? AND  wmc.id IN (1, 2)  ORDER BY code desc");
		when(jdbcTemplate.query(any(String.class), any(Object[].class), any(MeterCostRowMapper.class)))
				.thenReturn(getListOfMeterCosts());
		assertTrue(getListOfMeterCosts().equals(meterCostRepository.searchMeterCostByCriteria(getMeterCostCriteria())));
	}

	@Test
	public void test_should_return_false_if__meter_make_exists_in_DB_and_code_is_null() {
		List<Map<String, Object>> meterCost = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("code", "MM");
		meterCost.add(map);
		final List<Object> preparedStatementValues = new ArrayList<>();
		preparedStatementValues.add("MeterMake");
		preparedStatementValues.add("default");
		when(meterCostQueryBuilder.selectMeterCostByNameAndTenantIdQuery())
				.thenReturn("select code FROM egwtr_metercost where metermake = ? and tenantId = ?");
		when(jdbcTemplate.queryForList("select code FROM" + " egwtr_metercost where metermake = ? and tenantId = ?",
				preparedStatementValues.toArray())).thenReturn(meterCost);
		assertTrue(meterCostRepository.checkMeterMakeAlreadyExistsInDB(getMeterCost()).equals(false));
	}

	@Test
	public void test_should_return_true_if__meter_make_exists_in_DB_and_code_is_null() {
		List<Map<String, Object>> meterCost = new ArrayList<>();
		final List<Object> preparedStatementValues = new ArrayList<>();
		preparedStatementValues.add("MeterMake");
		preparedStatementValues.add("default");
		when(meterCostQueryBuilder.selectMeterCostByNameAndTenantIdQuery())
				.thenReturn("select code FROM egwtr_metercost where metermake = ? and tenantId = ?");
		when(jdbcTemplate.queryForList("select code FROM" + " egwtr_metercost where metermake = ? and tenantId = ?",
				preparedStatementValues.toArray())).thenReturn(meterCost);
		assertTrue(meterCostRepository.checkMeterMakeAlreadyExistsInDB(getMeterCost()).equals(true));
	}

	@Test
	public void test_should_return_false_if__meter_make_exists_in_DB_and_code_is_notnull() {
		List<Map<String, Object>> meterCost = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("code", "MM");
		meterCost.add(map);
		final List<Object> preparedStatementValues = new ArrayList<>();
		preparedStatementValues.add("MeterMake");
		preparedStatementValues.add("default");
		preparedStatementValues.add("MMS");
		when(meterCostQueryBuilder.selectMeterCostByNameTenantIdAndCodeNotInQuery())
				.thenReturn("select code from egwtr_metercost where metermake = ? and tenantId = ? and code != ? ");
		when(jdbcTemplate.queryForList(
				"select code from egwtr_metercost where metermake = ? and tenantId = ? and code != ? ",
				preparedStatementValues.toArray())).thenReturn(meterCost);
		assertTrue(meterCostRepository.checkMeterMakeAlreadyExistsInDB(getMeterCostIfCodeIsNotNull()).equals(false));
	}

	@Test
	public void test_should_return_true_if__meter_make_exists_in_DB_and_code_is_notnull() {
		List<Map<String, Object>> meterCost = new ArrayList<>();
		final List<Object> preparedStatementValues = new ArrayList<>();
		preparedStatementValues.add("MeterMake");
		preparedStatementValues.add("default");
		preparedStatementValues.add("MMS");
		when(meterCostQueryBuilder.selectMeterCostByNameTenantIdAndCodeNotInQuery())
				.thenReturn("select code from egwtr_metercost where metermake = ? and tenantId = ? and code != ? ");
		when(jdbcTemplate.queryForList(
				"select code from egwtr_metercost where metermake = ? and tenantId = ? and code != ? ",
				preparedStatementValues.toArray())).thenReturn(meterCost);
		assertTrue(meterCostRepository.checkMeterMakeAlreadyExistsInDB(getMeterCostIfCodeIsNotNull()).equals(true));
	}

	private MeterCost getMeterCostIfCodeIsNotNull() {
		return MeterCost.builder().id(1L).meterMake("MeterMake").code("MMS").active(true).amount(1000.0).createdBy(1L)
				.lastModifiedBy(1L).tenantId("default").build();
	}

	private MeterCost getMeterCost() {
		return MeterCost.builder().id(1L).meterMake("MeterMake").active(true).amount(1000.0).createdBy(1L)
				.lastModifiedBy(1L).tenantId("default").build();
	}

	private List<MeterCost> getListOfMeterCosts() {
		MeterCost meterCost1 = MeterCost.builder().id(1L).code("MeterCost123").pipeSizeId(1L).meterMake("meterMake123")
				.amount(4000.0).active(true).createdBy(1L).lastModifiedBy(1L).tenantId("default").build();
		MeterCost meterCost2 = MeterCost.builder().id(2L).code("MeterCost234").pipeSizeId(2L).meterMake("meterMake234")
				.amount(5000.0).active(true).createdBy(1L).lastModifiedBy(1L).tenantId("default").build();
		return Arrays.asList(meterCost1, meterCost2);
	}

	private MeterCostCriteria getMeterCostCriteria() {
		return MeterCostCriteria.builder().active(true).ids(Arrays.asList(1L, 2L)).tenantId("default").sortby("code")
				.sortOrder("desc").build();
	}

	private MeterCostReq getMeterCostRequestForUpdate() {
		User userInfo = User.builder().id(1L).build();
		RequestInfo requestInfo = RequestInfo.builder().apiId("org.egov.wcms").ver("1.0").action("POST")
				.did("4354648646").key("xyz").msgId("654654").authToken("345678f").userInfo(userInfo).build();
		MeterCost meterCost1 = MeterCost.builder().id(1L).code("MeterCost123").pipeSizeId(1L)
				.meterMake("meterMakeUpdated1").amount(3000.0).active(true).createdBy(1L).lastModifiedBy(1L)
				.tenantId("default").build();
		MeterCost meterCost2 = MeterCost.builder().id(2L).code("MeterCost234").pipeSizeId(2L)
				.meterMake("meterMakeUpdated2").amount(4000.0).active(true).createdBy(1L).lastModifiedBy(1L)
				.tenantId("default").build();
		return MeterCostReq.builder().requestInfo(requestInfo).meterCost(Arrays.asList(meterCost1, meterCost2)).build();

	}

	private MeterCostReq getMeterCostRequest() {
		User userInfo = User.builder().id(1L).build();
		RequestInfo requestInfo = RequestInfo.builder().apiId("org.egov.wcms").ver("1.0").action("POST")
				.did("4354648646").key("xyz").msgId("654654").authToken("345678f").userInfo(userInfo).build();
		MeterCost meterCost1 = MeterCost.builder().id(1L).code("MeterCost123").pipeSizeId(1L).meterMake("meterMake123")
				.amount(4000.0).active(true).createdBy(1L).lastModifiedBy(1L).tenantId("default").build();
		MeterCost meterCost2 = MeterCost.builder().id(2L).code("MeterCost234").pipeSizeId(2L).meterMake("meterMake234")
				.amount(5000.0).active(true).createdBy(1L).lastModifiedBy(1L).tenantId("default").build();
		return MeterCostReq.builder().requestInfo(requestInfo).meterCost(Arrays.asList(meterCost1, meterCost2)).build();

	}

}