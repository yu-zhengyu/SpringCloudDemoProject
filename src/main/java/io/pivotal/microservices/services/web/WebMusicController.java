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
 * @date 2016年4月26日
 */
@Controller
public class WebMusicController {
    @Autowired
    protected WebMusicService musicService;
    
    @RequestMapping("/music")
    public String goHome() {
        return "index";
    }
    
    public WebMusicController(WebMusicService musicService) {
        this.musicService = musicService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("musicname", "searchText");
    }
    
    @RequestMapping("/music/{musicname}")
    public String getMusicByName(Model model, @PathVariable("musicname") String musicname) {
        String url = "http://api.onemusicapi.com/20151208/artist?user_key=030562ae55909f815c73a27290dc9525&called=" + musicname;
        url = url.replaceAll(" ", "%20");
        String music = SendURL.sendGet(url);
        JsonElement jelement = new JsonParser().parse(music);
        JsonObject jobject = jelement.getAsJsonArray().get(0).getAsJsonObject();
        JsonElement name_eleElement = jobject.get("name");
        JsonElement aliases_eleElement = jobject.get("aliases").getAsJsonArray().get(0);
        JsonElement country_eleElement = jobject.get("country");
        model.addAttribute("name", name_eleElement.getAsString());
        model.addAttribute("aliases", aliases_eleElement.getAsString());
        model.addAttribute("country", country_eleElement.getAsString());
        return "music";
    }
}
