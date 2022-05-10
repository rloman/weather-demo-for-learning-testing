package nl.codefounders.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integrationtest")
class WeatherApplicationIT {

	@Test
	void contextLoads() {
	}

}
