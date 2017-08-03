/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 * accountability and the service delivery of the government  organizations.
 *
 *  Copyright (C) 2016  eGovernments Foundation
 *
 *  The updated version of eGov suite of products as by eGovernments Foundation
 *  is available at http://www.egovernments.org
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see http://www.gnu.org/licenses/ or
 *  http://www.gnu.org/licenses/gpl.html .
 *
 *  In addition to the terms of the GPL license to be adhered to in using this
 *  program, the following additional terms are to be complied with:
 *
 *      1) All versions of this program, verbatim or modified must carry this
 *         Legal Notice.
 *
 *      2) Any misrepresentation of the origin of the material is prohibited. It
 *         is required that all modified versions of this material be marked in
 *         reasonable ways as different from the original version.
 *
 *      3) This license does not grant any rights to any user of the program
 *         with regards to rights under trademark law for use of the trade names
 *         or trademarks of eGovernments Foundation.
 *
 *  In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */

package org.egov.pgr.repository;

import org.egov.pgr.repository.builder.ReceivingModeTypeQueryBuilder;
import org.egov.pgr.web.contract.ReceivingMode;
import org.egov.pgr.web.contract.ReceivingModeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ReceivingModeRepository {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReceivingModeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ReceivingModeTypeQueryBuilder receivingModeTypeQueryBuilder;

    public ReceivingModeRequest persistReceivingModeType(final ReceivingModeRequest modeTypeRequest) {
        LOGGER.info("ReceivingMode Create Request::" + modeTypeRequest);
        final String receivingModeTypeInsert = ReceivingModeTypeQueryBuilder.insertReceivingModeTypeQuery();
        final String receivingModeChannelInsert = ReceivingModeTypeQueryBuilder.insertReceivingModeChannelQuery();
        final ReceivingMode modeType = modeTypeRequest.getReceivingMode();
        final Object[] obj = new Object[]{modeType.getCode(), modeType.getName(), modeType.getDescription(),
                modeType.getActive(),
                Long.valueOf(modeTypeRequest.getRequestInfo().getUserInfo().getId()),
                Long.valueOf(modeTypeRequest.getRequestInfo().getUserInfo().getId()),
                new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()),
                modeType.getTenantId()};
        jdbcTemplate.update(receivingModeTypeInsert, obj);

        insertReceivingModeChannel(modeType, receivingModeChannelInsert);
        return modeTypeRequest;
    }


    private void insertReceivingModeChannel(final ReceivingMode modeType, final String receivingModeChannelInsert) {

        if (modeType.getChannels() != null && modeType.getChannels().size() != 0) {

            List<String> distinctChannelList = modeType.getChannels().stream().distinct().collect(Collectors.toList());

            jdbcTemplate.batchUpdate(receivingModeChannelInsert, new BatchPreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    String channel = distinctChannelList.get(i);
                    ps.setString(1, modeType.getCode());
                    ps.setString(2, channel);

                }

                @Override
                public int getBatchSize() {
                    return distinctChannelList.size();
                }
            });
        }

    }

    public ReceivingModeRequest persistModifyReceivingModeType(final ReceivingModeRequest modeTypeRequest) {
        LOGGER.info("ReceivingMode Update Request::" + modeTypeRequest);
        final String receivingCenterTypeUpdate = ReceivingModeTypeQueryBuilder.updateReceivingModeTypeQuery();
        final String receivingModeChannelInsert = ReceivingModeTypeQueryBuilder.insertReceivingModeChannelQuery();
        final ReceivingMode modeType = modeTypeRequest.getReceivingMode();
        final Object[] obj = new Object[]{modeType.getName(), modeType.getDescription(),
                modeType.getActive(), Long.valueOf(modeTypeRequest.getRequestInfo().getUserInfo().getId()),
                new Date(new java.util.Date().getTime()), modeType.getCode()};
        jdbcTemplate.update(receivingCenterTypeUpdate, obj);

        if (modeType.getChannels() != null && modeType.getChannels().size() != 0) {

            final String receivingCenterChanneldelete = ReceivingModeTypeQueryBuilder.deleteReceivingModeChannelQuery();
            jdbcTemplate.update(receivingCenterChanneldelete, new Object[]{modeType.getCode()});


        }

        insertReceivingModeChannel(modeType, receivingModeChannelInsert);

        return modeTypeRequest;

    }

/*    public List<ReceivingMode> getAllReceivingModeTypes(final ReceivingModeTypeGetReq modeTypeGetRequest) {
        LOGGER.info("ReceivingMode search Request::" + modeTypeGetRequest);
        final List<Object> preparedStatementValues = new ArrayList<>();
        final String queryStr = receivingModeTypeQueryBuilder.getQuery(modeTypeGetRequest, preparedStatementValues);
        ReceivingModeTypeRowMapper receivingModeRowMapper = new ReceivingModeTypeRowMapper();
        jdbcTemplate.query(queryStr, preparedStatementValues.toArray(), receivingModeRowMapper);
        Map<String, ReceivingMode> modeMap = receivingModeRowMapper.modeMap;
        Iterator<Entry<String, ReceivingMode>> itr = modeMap.entrySet().iterator();
        List<ReceivingMode> receivingModeList = new ArrayList<>();
        while (itr.hasNext()) {
            Entry<String, ReceivingMode> itrEntry = itr.next();
            receivingModeList.add(itrEntry.getValue());
        }
        return receivingModeList;
    }*/

    public boolean checkReceivingModeTypeByCode(final String code, final String tenantId) {
        final List<Object> preparedStatementValues = new ArrayList<>();

        preparedStatementValues.add(tenantId);
        String query = "";
        if (code != null && code != "") {

            preparedStatementValues.add(code);
            query = ReceivingModeTypeQueryBuilder.checkReceivinModeTypeByNameAndCode();

        }
        final List<Map<String, Object>> centerTypes = jdbcTemplate.queryForList(query,
                preparedStatementValues.toArray());

        if (!centerTypes.isEmpty()) {
            String codeFromDB = (String) centerTypes.get(0).get("code");
            if (codeFromDB.equalsIgnoreCase(code))
                return true;
        }
        return false;

    }

    public boolean checkReceivingModeTypeByName(final String code, final String name, final String tenantId) {
        final List<Object> preparedStatementValues = new ArrayList<>();

        preparedStatementValues.add(tenantId);
        String query = "";
        if (null != name && name != "") {

            preparedStatementValues.add(name.toUpperCase());
            query = ReceivingModeTypeQueryBuilder.checkReceivinModeTypeByName();

        }

        final List<Map<String, Object>> centerTypes = jdbcTemplate.queryForList(query,
                preparedStatementValues.toArray());

        if (!centerTypes.isEmpty()) {
            String codeFromDb = (String) centerTypes.get(0).get("code");
            if (!codeFromDb.equalsIgnoreCase(code))
                return true;
        }

        return false;
    }


}