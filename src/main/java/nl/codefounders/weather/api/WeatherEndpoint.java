package nl.codefounders.weather.api;

import nl.codefounders.weather.WeatherConfig;
import nl.codefounders.weather.model.Weather;
import nl.codefounders.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/weather")
public class WeatherEndpoint {

    @Autowired
    private WeatherConfig weatherConfig;

    @Autowired
    private WeatherService weatherService;

    @Value("${companyName}")
    private String companyName;

    @Value("den poedel") // terugzetten naar #{systemProperties.myVersion}   (binnen de quotes)
    private String version;

    @PostMapping
    public Weather create(@RequestBody Weather source) {
        System.err.printf("%-40s%n", this.weatherConfig.getType());
        System.err.printf("%-40s%d%n", "Brought by: " + companyName, companyName.length());
        System.err.printf("%-40s%d%n", "Version: " + this.version, this.version.length());


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
