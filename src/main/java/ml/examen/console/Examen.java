package ml.examen.console;

import java.util.ArrayList;
import java.util.List;

import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.PositionalWeatherService;
import ml.examen.weather.Weather;
import ml.examen.weather.WeatherService;

public class Examen {

	public static void main(String[] args) {
		

		WeatherService weatherService = new PositionalWeatherService();
		
		int droughtsQty = 0;
		int rainsQty = 0;
		int optimalsQty = 0;

		boolean yestrdayWasRainy = false;
		double maxRainAmoutInPeriod = 0;
		int dayOfMaxRainAmoutInPeriod = 0;
		
		List<Integer> maximunRainyDays =  new ArrayList<>();
		
		for (int i = 0; i < 10 * 365; i++) {
			Weather weather = weatherService.forecastWheater(i, SolarSystem.build());
			
			if(weather.isDroughtPeriod()) {
				droughtsQty++;	
			}
			
			if (weather.isOptimalPresureAndTemperature()) {
				optimalsQty++;
			}

			boolean isRainingToday = weather.isRainyPeriod();
			if (isRainingToday) {
				if(maxRainAmoutInPeriod < weather.getRainAmount()) {
					maxRainAmoutInPeriod = weather.getRainAmount();
					dayOfMaxRainAmoutInPeriod = i;
				}
			}
			
			boolean rainyPeriodEndsToday = !isRainingToday && yestrdayWasRainy;

			if(rainyPeriodEndsToday) {
				rainsQty++;
				maxRainAmoutInPeriod = 0;
				maximunRainyDays.add(i-1);
			}

		}
		
		System.out.println("Cantidad periodos de sequia: " + droughtsQty);
		System.out.println("Cantidad periodos de lluvia: " + rainsQty);
		System.out.println("Dias mas lluviosos: " + maximunRainyDays);
		System.out.println("Cantidad periodos de condiciones optimas: " + optimalsQty);

	}

}
