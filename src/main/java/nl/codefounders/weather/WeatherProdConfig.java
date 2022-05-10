package nl.codefounders.weather;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!integrationtest")
public class WeatherProdConfig implements WeatherConfig {


    @Override
    public String getType() {
        return "prod";
    }
}
