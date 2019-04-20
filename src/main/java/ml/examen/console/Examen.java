package ml.examen.console;

import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.ForecastSummary;
import ml.examen.weather.PositionalWeatherService;
import ml.examen.weather.WeatherService;

public class Examen {

	public static void main(String[] args) {
		

		WeatherService weatherService = new PositionalWeatherService();
		ForecastSummary summary = weatherService.forecastSummary(10, SolarSystem.build());
		System.out.println(summary);
	}

}
