package io.pivotal.microservices.music;


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
@EntityScan("io.pivotal.microservices.music")
@EnableJpaRepositories("io.pivotal.microservices.music")
public class MusicWebApplication {
    protected Logger logger = Logger.getLogger(MusicWebApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(MusicWebApplication.class, args);
    }
}
