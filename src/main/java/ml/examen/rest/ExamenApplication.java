package ml.examen.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ml.examen.geometry.DoublePrecisonGeometry;
import ml.examen.geometry.Geometry;
import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.Weather;

@SpringBootApplication
@ComponentScan("ml.examen")
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Bean
	ExecutorService executorService() {
		return Executors.newCachedThreadPool();
	}

	@Bean
	List<Weather> weatherForecastRepository() {
		return new ArrayList<>();
	}

	@Bean
	SolarSystem solarSystem() {
		return SolarSystem.build();
	}

	@Bean
	Geometry<Double> doublePrecisionGeometry() {
		return new DoublePrecisonGeometry(0.0001);
	}

	
	
}
