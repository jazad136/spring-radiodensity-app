package net.saddlercoms.radiodensity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.saddlercoms.radiodensity.response.PingResponse;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RadiodensityControllerTests {
	
	public static final Logger LOG = LoggerFactory.getLogger(RadiodensityControllerTests.class);
	@Autowired public TestRestTemplate testRestTemplate;
	
	@BeforeAll
	public static void beforeAll() { 
		LOG.warn("***TESTS***");
	}
	@AfterAll
	public static void afterAll() { 
		LOG.warn("***END TESTS***");
	}
	
	@Configuration
	@ComponentScan(basePackages={"net.saddlercoms.radiodensity"})
	public static class TestInfrastructureConfig
	{
		
	}
	
	@Test
	public void test_pingResponse_returnsSuccessTrue() { 
		ResponseEntity<PingResponse> pingResponse = testRestTemplate.getForEntity("/api/cities/ping", PingResponse.class);
		assertThat(pingResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(pingResponse.getBody()).isExactlyInstanceOf(PingResponse.class);
		assertThat(pingResponse.getBody().getSuccess()).isEqualTo(true);		
	}
}
