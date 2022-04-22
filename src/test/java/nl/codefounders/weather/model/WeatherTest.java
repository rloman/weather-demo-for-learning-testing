package nl.codefounders.weather.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherTest {
	
	private Weather weather;
	
	
	@BeforeEach
	public void init() {
		this.weather = new Weather();
	}
	
	@Test
	public void testGettersAndSetters() {
		
		weather.setCity("Utrecht");
		weather.setTemperature(12.3);
		
		assertEquals("Utrecht", weather.getCity());
		assertEquals(12.3, weather.getTemperature());
	}
	
	@Test
	public void testIsFris() {
		weather.setTemperature(14.0);
		assertTrue(weather.isFris());
		weather.setTemperature(33.0);
		assertFalse(weather.isFris());
	}
	
	@Test
	public void testIsWarm() {
		weather.setTemperature(34.0);
		assertTrue(weather.isWarm());
		weather.setTemperature(25.0);
		assertFalse(weather.isWarm());
	}
}
