package nl.codefounders.weather.api;

import nl.codefounders.weather.model.Weather;
import nl.codefounders.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/weather")
public class WeatherEndpoint {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public Weather create(@RequestBody Weather source) {
        return this.weatherService.save(source);
    }


    @GetMapping
    public List<Weather> findAll() {
        return this.weatherService.findAll();
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
