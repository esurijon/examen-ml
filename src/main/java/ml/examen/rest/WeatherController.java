package ml.examen.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.Weather;
import ml.examen.weather.ForecastService;

@RestController
@RequestMapping(path = "/clima")
public class WeatherController {

	private ForecastService forecastService;
	private SolarSystem solarSystem;

	public WeatherController(ForecastService forecastService, SolarSystem solarSystem) {
		this.forecastService = forecastService;
		this.solarSystem = solarSystem;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Weather getWheather(@RequestParam(name = "day", defaultValue = "0") int day) {
		return forecastService.forecastWheater(day, solarSystem);
	}

}
