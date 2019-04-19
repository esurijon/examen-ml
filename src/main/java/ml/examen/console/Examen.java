package ml.examen.console;

import java.util.ArrayList;
import java.util.List;

import ml.examen.geometry.IntegerGeometry;
import ml.examen.geometry.PolarCoord;
import ml.examen.solarsystem.Planet;
import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.PositionalWeatherService;
import ml.examen.weather.WeatherService;
import ml.examen.weather.Weather;

public class Examen {

	public static void main(String[] args) {
		
		Planet ferengi = new Planet("ferengi", 1 , new PolarCoord<Integer>(500, 0));
		Planet betasoide = new Planet("betasoide", 3 , new PolarCoord<Integer>(2000, 0));
		Planet vulcano = new Planet("vulcano", -5 , new PolarCoord<Integer>(1000, 0));
		
		SolarSystem solarSystem = new SolarSystem(ferengi, betasoide, vulcano);

		WeatherService weatherService = new PositionalWeatherService(new IntegerGeometry());
		int droughtsQty = 0;
		int rainsQty = 0;
		int optimalsQty = 0;
		List<Integer> maximunRainyDays =  new ArrayList<>();
		
		for (int i = 0; i < 10 * 365; i++) {
			Weather weather = weatherService.forecastWheater(i, solarSystem);
			if(weather.isDroughtPeriod()) droughtsQty++;
			if(weather.isRainyPeriod()) rainsQty++;
			if(weather.isMaximunRainyDay()) maximunRainyDays.add(weather.getDay());
			if(weather.isOptimalPresureAndTemperature()) optimalsQty++;
		}
		
		System.out.println("Cantidad periodos de sequia: " + droughtsQty);
		System.out.println("Cantidad periodos de lluvia: " + rainsQty);
		System.out.println("Dias mas lluviosos: " + maximunRainyDays);
		System.out.println("Cantidad periodos de condiciones optimas: " + optimalsQty);

	}

}
