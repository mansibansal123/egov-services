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

package org.egov.eis.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.egov.eis.config.ApplicationProperties;
import org.egov.eis.model.Position;
import org.egov.eis.repository.VacantPositionsRepository;
import org.egov.eis.web.contract.NonVacantPositionsResponse;
import org.egov.eis.web.contract.RequestInfo;
import org.egov.eis.web.contract.VacantPositionsGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VacantPositionsService {

	@Autowired
	private VacantPositionsRepository vacantPositionsRepository;

	@Autowired
	private ApplicationProperties applicationProperties;

	public List<Position> getVacantPositions(VacantPositionsGetRequest vacantPositionsGetRequest,
			RequestInfo requestInfo) {
		String url = applicationProperties.hrServicesHREmployeeServiceEmployeeHostRequest()
			+ "?tenantId=" + vacantPositionsGetRequest.getTenantId()
			+ "&departmentId=" + vacantPositionsGetRequest.getDepartmentId()
			+ "&designationId=" + vacantPositionsGetRequest.getDesignationId()
			+ "&asOnDate=" + new SimpleDateFormat("dd/MM/yyyy").format(vacantPositionsGetRequest.getAsOnDate());

		System.err.println(url);
		NonVacantPositionsResponse nonVacantPositionsResponse = new RestTemplate().postForObject(url, requestInfo,
				NonVacantPositionsResponse.class);

		if(!nonVacantPositionsResponse.getPositionIds().isEmpty())
			vacantPositionsGetRequest.setId(nonVacantPositionsResponse.getPositionIds());

		return vacantPositionsRepository.findForCriteria(vacantPositionsGetRequest);
	}

}