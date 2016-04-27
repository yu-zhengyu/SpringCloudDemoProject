package io.pivotal.microservices.weather;
import java.util.logging.Logger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@SpringBootApplication
@EntityScan("io.pivotal.microservices.weather")
@EnableJpaRepositories("io.pivotal.microservices.weather")
@PropertySource("classpath:db-config.properties")
public class WeatherWebApplication {
    
    protected Logger logger = Logger.getLogger(WeatherWebApplication.class.getName());
    
    public static void main(String[] args) {
        SpringApplication.run(WeatherWebApplication.class, args);
    }   

}
