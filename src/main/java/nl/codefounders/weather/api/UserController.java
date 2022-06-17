package nl.codefounders.weather.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    final String api = "https://jsonplaceholder.typicode.com/users";

    @GetMapping
    public ResponseEntity<List> getUsers() {
        try {
            ResponseEntity<List> result = this.restTemplate.getForEntity(new URI(this.api), List.class);
            return result;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
