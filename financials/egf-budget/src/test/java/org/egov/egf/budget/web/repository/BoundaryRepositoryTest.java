package org.egov.egf.budget.web.repository;

import org.egov.egf.budget.domain.service.DateFactory;
import org.egov.egf.budget.utils.RequestJsonReader;
import org.egov.egf.budget.web.contract.Boundary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(MockitoJUnitRunner.class)
public class BoundaryRepositoryTest {

    private static final String HOST = "http://host/";

    private MockRestServiceServer server;

    private BoundaryRepository boundaryRepository;

    private RequestJsonReader resources = new RequestJsonReader();

    @Before
    public void setup() {
        final RestTemplate restTemplate = new RestTemplate();
        boundaryRepository = new BoundaryRepository(restTemplate, HOST);
        server = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Test
    public void test_get_by_id() throws Exception {

        server.expect(once(), requestTo("http://host/egov-location/boundarys?boundary.id=boundaryId&boundary.tenantId=tenantId")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(resources.getFileContents("boundary/search_boundary_by_id.json"),
                        MediaType.APPLICATION_JSON_UTF8));

        final Boundary response = boundaryRepository.getBoundaryById("boundaryId", "tenantId");

        server.verify();

        assertEquals(1, 1);

    }
}