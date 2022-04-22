package nl.codefounders.weather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import nl.codefounders.weather.model.Weather;
import nl.codefounders.weather.persistence.WeatherRepository;

/*
Het probleem is hier:
We kunnen niet een repository aanroepen want het is 
1) een interface en 
2) we willen dat NIET.
UNITTESTEN ZIJN ALTIJD TESTEN DIE EEN unit testen en dus geeen!!!!  collaborators
Hoe lossen we dit op? Met het principe van Mocking en Spring Boot levert ons Mockito daarvoor.
We beschrijven dan een GOED GEDRAG VAN DE repository en die laten we gebruiken door de Service

Beginnersfout:
Soms zie ik dat iemand de WeatherService gaat mocken. je moet de WeatherRepo mocken!
 */

public class WeatherServiceTest {
	
	@InjectMocks // dit zorgt ervoor dat Mockito in de weatherService de benodige Mocks injecteert
	private WeatherService weatherService;
	
	@Mock
	private WeatherRepository weatherRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testFindByCity() {
		
		// Given
		// This mocking
		Weather timboektoe = new Weather();
		timboektoe.setCity("Timboektoe");
		timboektoe.setTemperature(33.4);
		Optional<Weather> optionalWeatherMock = Optional.of(timboektoe);
		Mockito.when(this.weatherRepository.findByCity("Timboektoe")).thenReturn(optionalWeatherMock);
		
		
		// When  (let op: je roept hier dus de class under test aan
		Optional<Weather>  optionalWeather = this.weatherService.findByCity("Timboektoe");
		
		// Then
		assertEquals("Timboektoe", optionalWeather.get().getCity());
		assertEquals(33.4, optionalWeather.get().getTemperature());
		
		Mockito.verify(this.weatherRepository, Mockito.times(1)).findByCity("Timboektoe");
		Mockito.verify(this.weatherRepository).findByCity("Timboektoe");
		
	}
}
