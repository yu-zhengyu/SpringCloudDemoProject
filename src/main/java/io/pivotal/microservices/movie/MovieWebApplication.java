package io.pivotal.microservices.movie;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@SpringBootApplication
@EntityScan("io.pivotal.microservices.movie")
@EnableJpaRepositories("io.pivotal.microservices.movie")
public class MovieWebApplication {
    
    protected Logger logger = Logger.getLogger(MovieWebApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(MovieWebApplication.class, args);
    }
}
