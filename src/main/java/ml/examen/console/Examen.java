package ml.examen.console;

import ml.examen.geometry.DoublePrecisonGeometry;
import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.ForecastSummary;
import ml.examen.weather.PositionalForecastService;
import ml.examen.weather.ForecastService;

public class Examen {

	public static void main(String[] args) {

		ForecastService forecastService = new PositionalForecastService(new DoublePrecisonGeometry(0.0001));
		ForecastSummary summary = forecastService.forecastSummary(10, SolarSystem.build());
		System.out.println(summary);

	}

}
