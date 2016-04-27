package io.pivotal.microservices.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengyu
 * @date 2016年4月25日
 */
@Service
public class WebMovieService {
    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl;
    
    public WebMovieService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }
}
