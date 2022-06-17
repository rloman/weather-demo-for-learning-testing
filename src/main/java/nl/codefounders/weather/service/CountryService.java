package nl.codefounders.weather.service;

import nl.codefounders.weather.dto.CitiesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    String apiFormatString = "https://countriesnow.space/api/v0.1/countries/cities/q?country=%s";

    public CitiesResult getCitiesForCountry(String country) {

        final URI uri;
        try {
            uri = new URI(String.format(apiFormatString, country));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new CitiesResult();
        }
        ResponseEntity<CitiesResult> result = this.restTemplate.getForEntity(uri, CitiesResult.class);

        return result.getBody();
    }
}

