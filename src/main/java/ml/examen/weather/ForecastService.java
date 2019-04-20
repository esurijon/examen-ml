package ml.examen.weather;

import ml.examen.solarsystem.SolarSystem;

public interface ForecastService {
	
	public Weather forecastWheater(int day, SolarSystem system);

	public ForecastSummary forecastSummary(int years, SolarSystem system);
	
	
}
