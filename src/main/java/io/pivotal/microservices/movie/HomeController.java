package io.pivotal.microservices.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/movie")
    public String goHome(Model model) {
        return "index";
    }
}
