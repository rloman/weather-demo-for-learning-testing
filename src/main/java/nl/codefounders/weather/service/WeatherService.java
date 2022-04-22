package nl.codefounders.weather.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.codefounders.weather.model.Weather;
import nl.codefounders.weather.persistence.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;

	public Optional<Weather> findByCity(String city) {
		Optional<Weather> result = weatherRepository.findByCity(city);
		 // this makes the unittest with Mockito break => result.get().setTemperature(25.0);
		
		return result;
	}

	public Weather save(Weather entity) {
		return weatherRepository.save(entity);
	}

	public List<Weather> findAll() {
		return weatherRepository.findAll();
	}

	public Optional<Weather> findById(Long id) {
		return weatherRepository.findById(id);
	}

	public void deleteById(Long id) {
		weatherRepository.deleteById(id);
	}
}
