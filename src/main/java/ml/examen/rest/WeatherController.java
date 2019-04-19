package ml.examen.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.examen.weather.Weather;

@RestController
@RequestMapping(path = "/clima")
public class WeatherController {

	@RequestMapping(method = RequestMethod.GET)
	public Weather getWheather(@RequestParam(name = "day", defaultValue = "0") int day) {
		return new Weather(0, false, true, true, false);
	}
	
}
