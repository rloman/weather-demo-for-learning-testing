package nl.codefounders.weather.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import nl.codefounders.weather.model.Weather;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@ActiveProfiles("integrationtest")
public class WeatherEndpointIT {

	private static final String ALMELO = "Almelo";

	@Autowired // (see this as Postman)
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int localPort;

	private String baseApi;

	@PostConstruct
	public void postConstruct() {
		String host = "localhost";
		String api = "api/weather";

		baseApi = String.format("http://%s:%d/%s", host, localPort, api);
	}

	@Test
	public void test1CreateUsingPost() {

		// Given
		Weather almelo = new Weather();
		almelo.setCity(ALMELO);
		almelo.setTemperature(12.0);

		// When
		ResponseEntity<Weather> response = restTemplate.postForEntity(baseApi, almelo, Weather.class);

		// Then
		Weather responseWeather = response.getBody();
		assertEquals(ALMELO, responseWeather.getCity());
		assertEquals(12.0, responseWeather.getTemperature());
	}

	@Test
	public void test2FindByCity() {

		// When
		ResponseEntity<Weather> response = restTemplate.getForEntity(baseApi + "/" + ALMELO, Weather.class);
		
		// Then
		Weather result = response.getBody();
		assertEquals(ALMELO, result.getCity());
		assertEquals(12.0, result.getTemperature());

	}
	
	@Test
	public void test3FindNotExistingCity() {
		// When
		ResponseEntity<Weather> response = restTemplate.getForEntity(baseApi + "/" + "Utrecht", Weather.class);
		
		// Then
		assertNull(response.getBody());
	}
}
