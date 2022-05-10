package nl.codefounders.weather.api;

import java.util.Optional;

import nl.codefounders.weather.WeatherConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.codefounders.weather.model.Weather;
import nl.codefounders.weather.service.WeatherService;

@RestController
@RequestMapping("api/weather")
public class WeatherEndpoint {

    @Autowired
    private WeatherConfig weatherConfig;

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public Weather create(@RequestBody Weather source) {
        System.err.println(this.weatherConfig.getType());

        return this.weatherService.save(source);
    }

    @GetMapping("{city}")
    public Weather findByName(@PathVariable String city ) {
        Optional<Weather> optionalWeather = this.weatherService.findByCity(city);
        if (optionalWeather.isPresent()) {
            return optionalWeather.get();
        }
        else {
            return null; // foei!
        }
    }
}
