package ml.examen.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.Weather;
import ml.examen.weather.WeatherService;

@RestController
@RequestMapping(path = "/clima")
public class WeatherController {

	private WeatherService weatherService;
	private SolarSystem solarSystem;

	public WeatherController(WeatherService weatherService, SolarSystem solarSystem) {
		this.weatherService = weatherService;
		this.solarSystem = solarSystem;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Weather getWheather(@RequestParam(name = "day", defaultValue = "0") int day) {
		return weatherService.forecastWheater(day, solarSystem);
	}

}
