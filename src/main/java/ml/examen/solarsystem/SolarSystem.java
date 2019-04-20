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
		Planet ferengi = new Planet("ferengi", 1 , new PolarCoord<Integer>(500, 0));
		Planet betasoide = new Planet("betasoide", 3 , new PolarCoord<Integer>(2000, 0));
		Planet vulcano = new Planet("vulcano", -5 , new PolarCoord<Integer>(1000, 0));
		
		return new SolarSystem(ferengi, betasoide, vulcano);
		
	}
}
