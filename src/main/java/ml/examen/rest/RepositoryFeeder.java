package ml.examen.rest;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ml.examen.solarsystem.SolarSystem;
import ml.examen.weather.ForecastService;
import ml.examen.weather.Weather;

@Component
public class RepositoryFeeder {

	private ForecastService forecastService;
	private SolarSystem solarSystem;
	private List<Weather> weatherForecastRepository;
	private ExecutorService executorService;

	@Autowired
	public RepositoryFeeder(ForecastService forecastService, SolarSystem solarSystem,  List<Weather> weatherForecastRepository, ExecutorService executorService) {
		this.forecastService = forecastService;
		this.solarSystem = solarSystem;
		this.weatherForecastRepository = weatherForecastRepository;
		this.executorService = executorService;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void feedRepo() {
		executorService.execute( () -> {
			for (int i = 0; i < 10 * 365; i++) {
				Weather weather = forecastService.forecastWheater(i, solarSystem);
				weatherForecastRepository.add(weather); 
			}
		});
	}

	@EventListener(ContextStoppedEvent.class)
	public void StopExecutor() {
		executorService.shutdown();
	}
}
