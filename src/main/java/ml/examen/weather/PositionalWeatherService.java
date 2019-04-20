package ml.examen.weather;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import ml.examen.geometry.IntegerGeometry;
import ml.examen.geometry.PolarCoord;
import ml.examen.solarsystem.SolarSystem;

@Service
public class PositionalWeatherService implements WeatherService {
	
	public PositionalWeatherService() {
	}
	
	@Override
	public Weather forecastWheater(int day, SolarSystem solarSystem) {
		@SuppressWarnings("unchecked")
		PolarCoord<Integer>[] coords = Arrays.asList(solarSystem.getPlanets())
			.stream()
			.map( planet -> planet.getPositionAt(day))
			.toArray(PolarCoord[]::new);
		
		boolean isDroughtPeriod = IntegerGeometry.areAllCoordsAlignedIncludingOrigin(coords);
		boolean isRainyPeriod = IntegerGeometry.isOriginSurroundedByPolygon(coords);
		double rainAmount = isRainyPeriod ? IntegerGeometry.trianglePerimiter(coords[0], coords[1], coords[2]) : 0;
		boolean isOptimalPresureAndTemperature = IntegerGeometry.areAllCoordsAlignedExcludingOrigin(coords[0], coords[1], coords[2]);

		Weather weather = new Weather(day, isDroughtPeriod, isRainyPeriod, rainAmount, isOptimalPresureAndTemperature);
		
		return weather ;
	}

	@Override
	public ForecastSummary forecastSummary(int years, SolarSystem solarSystem) {
		for (int i = 0; i < years * 365; i++) {
			this.forecastWheater(i, solarSystem);
		}
		return null;
	}

}
