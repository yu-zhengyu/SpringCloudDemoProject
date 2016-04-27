package io.pivotal.microservices.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Accounts web-server. Works as a microservice client, fetching data from the
 * Account-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
// Disable component scanner ...
@ComponentScan(useDefaultFilters = false)
public class WebServer {

	/**
	 * URL uses the logical name of account-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";
	public static final String WEATHER_SERVICE_URL = "http://WEATHER-SERVICE";
	public static final String MOVIE_SERVICE_URL = "http://MOVIE-SERVICE";
	public static final String MUSIC_SERVICE_URL = "http://MUSIC-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	/**
	 * The AccountService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public WebAccountsService accountsService() {
		return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public WebWeatherService weatherService() {
	    return new WebWeatherService(WEATHER_SERVICE_URL);
	}
	
	@Bean
	public WebMovieService movieService() {
	    return new WebMovieService(MOVIE_SERVICE_URL);
	}
	
	@Bean
	public WebMusicService musicService() {
	    return new WebMusicService(MOVIE_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link WebAccountsService} to use.
	 * 
	 * @return
	 */
	@Bean
	public WebAccountsController accountsController() {
		return new WebAccountsController(accountsService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	
	/**
	 * Weather controller
	 */
	@Bean
	public WebWeatherController weatherController() {
	    return new WebWeatherController(weatherService());
	}
	
	/**
	 * Movie controller
	 */
	@Bean
	public WebMovieController movieController() {
	    return new WebMovieController(movieService());
	}
	
	/**
	 * Music controller
	 */
	@Bean
	public WebMusicController musicController() {
	    return new WebMusicController(musicService());
	}
}
