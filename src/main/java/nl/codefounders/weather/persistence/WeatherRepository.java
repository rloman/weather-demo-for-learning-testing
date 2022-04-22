package nl.codefounders.weather.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.codefounders.weather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
	Optional<Weather> findByCity(String city);
}
