package io.pivotal.microservices.services.music;

import io.pivotal.microservices.music.MusicWebApplication;

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
@Import(MusicWebApplication.class)
public class MusicServer {
    protected Logger logger = Logger.getLogger(MusicServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     * 
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for accounts-server.properties or
        // movie-server.yml
        System.setProperty("spring.config.name", "music-server");
        
        SpringApplication.run(MusicServer.class, args);
    }
}
