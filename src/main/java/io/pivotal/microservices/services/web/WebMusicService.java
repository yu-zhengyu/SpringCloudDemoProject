package io.pivotal.microservices.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengyu
 * @date 2016年4月26日
 */
@Service
public class WebMusicService {
    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl;
    
    public WebMusicService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }
}
