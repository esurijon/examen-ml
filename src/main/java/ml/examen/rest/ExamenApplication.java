package ml.examen.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ml.examen.geometry.IntegerGeometry;
import ml.examen.solarsystem.SolarSystem;

@SpringBootApplication
@ComponentScan("ml.examen")
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Bean
	IntegerGeometry geometry() {
		return new IntegerGeometry();
	}

	@Bean
	SolarSystem solarSystem() {
		return SolarSystem.build();
	}

}
