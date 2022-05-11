package nl.codefounders.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		properties.setProperty("myVersion", "0.1.0-SNAPSHOTJE");
		SpringApplication.run(WeatherApplication.class, args);
	}
}
