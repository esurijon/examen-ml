package ml.examen.solarsystem;

import java.util.Arrays;

import ml.examen.geometry.PolarCoord;

public class SolarSystem {

	private Planet[] planets;
	
	public SolarSystem(Planet... planets) {
		this.planets = planets;
	}
	
	public Planet[] getPlanets() {
		return Arrays.copyOf(planets, planets.length);
	}
	
	public static SolarSystem build() {
		Planet ferengi = new Planet("ferengi", 1 , new PolarCoord<Double>(500d, 0d));
		Planet betasoide = new Planet("betasoide", 3 , new PolarCoord<Double>(2000d, 0d));
		Planet vulcano = new Planet("vulcano", -5 , new PolarCoord<Double>(1000d, 0d));
		
		return new SolarSystem(ferengi, betasoide, vulcano);
		
	}
}
