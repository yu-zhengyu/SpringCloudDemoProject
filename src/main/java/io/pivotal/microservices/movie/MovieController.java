package io.pivotal.microservices.movie;

import io.pivotal.microservices.services.web.SendURL;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@RestController
public class MovieController {
    protected Logger logger = Logger.getLogger(MovieController.class.getName());
    
    @RequestMapping("/movie/{name}")
    public String byName(@PathVariable("name") String name) {
        String url = "http://www.omdbapi.com/?t=" + name + "&y=&plot=short&r=json";
        String result = SendURL.sendGet(url);
        return result;
    }
}
