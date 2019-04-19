package ml.examen.solarsystem;

import java.util.Arrays;

public class SolarSystem {

	private Planet[] planets;
	
	public SolarSystem(Planet... planets) {
		this.planets = planets;
	}
	
	public Planet[] getPlanets() {
		return Arrays.copyOf(planets, planets.length);
	}
}
