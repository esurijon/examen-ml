package ml.examen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.examen.weather.Weather;

@RestController
@RequestMapping(path = "/clima")
public class WeatherController {

	private List<Weather> weatherForecastRepository;

	public WeatherController(List<Weather> weatherForecastRepository) {
		this.weatherForecastRepository = weatherForecastRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Weather> getWheather(@RequestParam(name = "day", defaultValue = "0") int day) {
		ResponseEntity<Weather> response;
		if(0 <= day && day < weatherForecastRepository.size()) {
			Weather weather = weatherForecastRepository.get(day);
			response = ResponseEntity.ok(weather);
		} else {
			response = ResponseEntity
				.notFound()
				.build();
		}
		return response ;
	}

}
