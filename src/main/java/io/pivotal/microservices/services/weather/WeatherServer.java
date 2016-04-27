package io.pivotal.microservices.services.weather;
import io.pivotal.microservices.weather.WeatherWebApplication;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author Yu Zheng
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(WeatherWebApplication.class)
public class WeatherServer {

	protected Logger logger = Logger.getLogger(WeatherServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "weather-server");

		SpringApplication.run(WeatherServer.class, args);
	}
}
