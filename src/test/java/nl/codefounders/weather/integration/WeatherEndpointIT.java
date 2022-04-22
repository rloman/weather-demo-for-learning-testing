package nl.codefounders.weather.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import nl.codefounders.weather.model.Weather;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherEndpointIT {
	
	@Autowired  // (see this as Postman)
	private TestRestTemplate restTemplate;
	
	private String host = "localhost";
	
	@LocalServerPort
	private int localPort;
	
	private String api = "api/weather";
	

	@Test
	public void test1CreateUsingPost() {
		
		// Given
		Weather almelo = new Weather();
		almelo.setCity("Almelo");
		almelo.setTemperature(12.0);
		
		String url = "http://"+host+":"+localPort+"/"+api;
		System.err.println("url is: "+url);
		
		// When
		ResponseEntity<Weather> response = restTemplate.postForEntity(url, almelo, Weather.class);
		
		// Then
		Weather responseWeather = response.getBody();
		
		assertEquals("Almelo", responseWeather.getCity());
		assertEquals(12.0, responseWeather.getTemperature());
	}
}
