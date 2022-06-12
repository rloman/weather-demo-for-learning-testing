package nl.codefounders.weather;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!integrationtest") // let op: hier staat NIET voor!
public class WeatherProdConfig implements WeatherConfig {


    @Override
    public String getType() {
        return "prod";
    }
}
