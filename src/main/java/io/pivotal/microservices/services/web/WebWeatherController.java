package io.pivotal.microservices.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author zhengyu
 * @date 2016年4月25日
 */
@Controller
public class WebWeatherController {
    
    @Autowired
    protected WebWeatherService weatherService;
    
    @RequestMapping("/weather")
    public String goHome() {
        return "index";
    }
    
    public WebWeatherController(WebWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("cityname", "searchText");
    }
    
    @RequestMapping("/weather/{cityname}")
    public String getWeatherByname(Model model, @PathVariable("cityname") String cityname) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityname + "&APPID=b9db49dd87de983112528816a191c1c7";
        String weather = SendURL.sendGet(url);
        JsonElement jelement = new JsonParser().parse(weather);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonElement name_Element = jobject.get("name");
        JsonElement sysElement = jobject.get("sys");
        JsonElement countryElement = sysElement.getAsJsonObject().get("country");
        JsonElement weatherElement = jobject.get("weather");
        JsonElement descriptionElement = weatherElement.getAsJsonArray().get(0).getAsJsonObject().get("description");
        model.addAttribute("name", name_Element.getAsString());
        model.addAttribute("country", countryElement.getAsString());
        model.addAttribute("weather", descriptionElement.getAsString());
        return "weather";
    }
}
