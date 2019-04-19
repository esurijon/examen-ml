package ml.examen.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ml.examen.geometry.IntegerGeometry;
import ml.examen.geometry.PolarCoord;
import ml.examen.solarsystem.Planet;
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
		Planet ferengi = new Planet("ferengi", 1, new PolarCoord<Integer>(500, 0));
		Planet betasoide = new Planet("betasoide", 3, new PolarCoord<Integer>(2000, 0));
		Planet vulcano = new Planet("vulcano", -5, new PolarCoord<Integer>(1000, 0));

		SolarSystem solarSystem = new SolarSystem(ferengi, betasoide, vulcano);
		return solarSystem;

	}

}
