package nl.codefounders.weather.beans;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BeansConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.setReadTimeout(Duration.ofSeconds(30));
        builder.setConnectTimeout(Duration.ofSeconds(10));
        return builder.build();
    }
}
