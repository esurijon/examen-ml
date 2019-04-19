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
		
		boolean isDroughtPeriod = IntegerGeometry.areAllCoordsAlignedWithOrigin(coords);
		boolean isRainyPeriod = IntegerGeometry.isOriginSurroundedByPolygon(coords);
		boolean isMaximunRainyDay = isRainyPeriod && IntegerGeometry.trianglePerimiterIsMaximun(coords[0], coords[1], coords[2]);
		boolean isOptimalPresureAndTemperature = IntegerGeometry.areAllCoordsAligned(coords);

		Weather weather = new Weather(day, isDroughtPeriod, isRainyPeriod, isMaximunRainyDay, isOptimalPresureAndTemperature);
		
		return weather ;
	}

}
