package nl.codefounders.weather;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("integrationtest")
public class WeatherDevConfig implements WeatherConfig {


    @Override
    public String getType() {
        return "dev";
    }
}
