package nl.codefounders.weather.api;

import nl.codefounders.weather.service.CountryService;
import nl.codefounders.weather.dto.CitiesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("{country}/cities")
    public ResponseEntity<CitiesResult> getCitesForCountry(@PathVariable String country) {

        CitiesResult citiesResult = this.countryService.getCitiesForCountry(country);
        if (citiesResult.isError() && "country not found".equals(citiesResult.getMsg())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(citiesResult, HttpStatus.OK);
        }
    }
}
