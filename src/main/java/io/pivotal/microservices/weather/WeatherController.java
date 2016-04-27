package io.pivotal.microservices.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
@RestController
public class WeatherController {
    protected Logger logger = Logger.getLogger(WeatherController.class.getName());
    
    @RequestMapping("/weather")
    public String goHome(Model model) {
        model.addAttribute("index");
        return "index";
    }
    
    @RequestMapping("/weather/{cityname}")
    public String byName(@PathVariable("cityname") String cityname) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityname + "&APPID=b9db49dd87de983112528816a191c1c7";
        String result = sendGet(url);
        return result;
    }
    
    @RequestMapping(value = "/search")
    public String doSearch() {
        
        return null;
    }

    public String sendGet(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int returncode = connection.getResponseCode();
            System.out.println(returncode);
            if (returncode != 200) {
                return returncode + "error";
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            StringBuilder context = new StringBuilder();
            while (true) {
                String line = in.readLine();
                if (line == null)
                    break;
                context.append(line);
            }
            in.close();
            return context.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
