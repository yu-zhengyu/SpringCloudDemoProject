package io.pivotal.microservices.services.movie;

import io.pivotal.microservices.movie.MovieWebApplication;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(MovieWebApplication.class)
public class MovieServer {

    protected Logger logger = Logger.getLogger(MovieServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     * 
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for accounts-server.properties or
        // movie-server.yml
        System.setProperty("spring.config.name", "movie-server");
        
        SpringApplication.run(MovieServer.class, args);
    }
}
