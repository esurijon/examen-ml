package ml.examen.weather;

import ml.examen.solarsystem.SolarSystem;

public interface WeatherService {
	
	public Weather forecastWheater(int day, SolarSystem system);

}
