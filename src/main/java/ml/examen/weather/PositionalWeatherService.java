package ml.examen.weather;

import java.util.Arrays;

import ml.examen.geometry.Geometry;
import ml.examen.geometry.PolarCoord;
import ml.examen.solarsystem.SolarSystem;

public class PositionalWeatherService implements WeatherService {
	
	private Geometry<Integer> geo;
	
	public PositionalWeatherService(Geometry<Integer> geo) {
		this.geo = geo;
	}
	
	@Override
	public Weather forecastWheater(int day, SolarSystem solarSystem) {
		PolarCoord<Integer>[] coords = Arrays.asList(solarSystem.getPlanets())
			.stream()
			.map( planet -> planet.getPositionAt(day))
			.toArray(PolarCoord[]::new);
		
		boolean isDroughtPeriod = geo.areAllCoordsAlignedWithOrigin(coords);
		boolean isRainyPeriod = geo.isOriginSurroundedByPolygon(coords);
		boolean isMaximunRainyDay = isRainyPeriod && geo.trianglePerimiterIsMaximun(coords[0], coords[1], coords[2]);
		boolean isOptimalPresureAndTemperature = geo.areAllCoordsAligned(coords);

		Weather weather = new Weather(day, isDroughtPeriod, isRainyPeriod, isMaximunRainyDay, isOptimalPresureAndTemperature);
		
		return weather ;
	}

}
