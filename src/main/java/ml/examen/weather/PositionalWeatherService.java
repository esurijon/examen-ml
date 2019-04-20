package ml.examen.weather;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ml.examen.geometry.Geometry;
import ml.examen.geometry.PolarCoord;
import ml.examen.solarsystem.SolarSystem;

@Service
public class PositionalWeatherService implements WeatherService {
	
	private Geometry<Double> geometry;

	@Autowired
	public PositionalWeatherService(Geometry<Double> geometry) {
		this.geometry = geometry;
	}
	
	@Override
	public Weather forecastWheater(int day, SolarSystem solarSystem) {
		@SuppressWarnings("unchecked")
		PolarCoord<Double>[] coords = Arrays.asList(solarSystem.getPlanets())
			.stream()
			.map( planet -> planet.getPositionAt(day))
			.toArray(PolarCoord[]::new);
		
		boolean isDroughtPeriod = geometry.areAllCoordsAlignedIncludingOrigin(coords);
		boolean isRainyPeriod = geometry.isOriginSurroundedByPolygon(coords);
		double rainAmount = isRainyPeriod ? geometry.trianglePerimiter(coords[0], coords[1], coords[2]) : 0;
		boolean isOptimalPresureAndTemperature = geometry.areAllCoordsAlignedExcludingOrigin(coords[0], coords[1], coords[2]);

		Weather weather = new Weather(day, isDroughtPeriod, isRainyPeriod, rainAmount, isOptimalPresureAndTemperature);
		
		return weather ;
	}

	@Override
	public ForecastSummary forecastSummary(int years, SolarSystem solarSystem) {
		int totalDays = years * 365;

		ForecastSummary summary = new ForecastSummary(totalDays);

		Period droghtPeriod = new Period();
		Period optimalsPeriod = new Period();
		Period rainsPeriod = new Period();

		double maxRainAmoutInPeriod = 0;
		int dayOfMaxRainAmoutInPeriod = 0;

		for (int i = 0; i < totalDays; i++) {
			boolean isLastDay = i == totalDays -1;
			Weather weather = forecastWheater(i, solarSystem);
			
			droghtPeriod.setActive(weather.isDrought());
			if(droghtPeriod.justEnded() || (droghtPeriod.isActive() && isLastDay)) {
				summary.addDroughtPeriod();
			}

			optimalsPeriod.setActive(weather.isOptimalPresureAndTemperature());
			if(optimalsPeriod.justEnded() || (optimalsPeriod.isActive() && isLastDay)) {
				summary.addOptimalsPeriod();
			}

			rainsPeriod.setActive(weather.isRainy());
			if(rainsPeriod.isActive() && maxRainAmoutInPeriod < weather.getRainAmount()) {
				maxRainAmoutInPeriod = weather.getRainAmount();
				dayOfMaxRainAmoutInPeriod = i;
			}
			if(rainsPeriod.justEnded() || (rainsPeriod.isActive() && isLastDay)) {
				summary.addRainsPeriodWithMaximun(dayOfMaxRainAmoutInPeriod);
				maxRainAmoutInPeriod = 0;
			}
		}
		return summary;
	}

}
