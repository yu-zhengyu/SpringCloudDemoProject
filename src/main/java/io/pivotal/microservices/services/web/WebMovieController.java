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
public class WebMovieController {
    @Autowired
    protected WebMovieService movieService;
    
    @RequestMapping("/movie")
    public String goHome() {
        return "index";
    }
    
    public WebMovieController(WebMovieService movieService) {
        this.movieService = movieService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("moviename", "searchText");
    }
    
    @RequestMapping("/movie/{moviename}")
    public String getMovieByName(Model model, @PathVariable("moviename") String moviename) {
        String url = "http://www.omdbapi.com/?t=" + moviename + "&y=&plot=short&r=json";
        String movie = SendURL.sendGet(url);
        JsonElement jelement = new JsonParser().parse(movie);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonElement title_Element = jobject.get("Title");
        JsonElement year_Element = jobject.get("Year");
        JsonElement plot_Element = jobject.get("Plot");
        JsonElement poster_eleElement = jobject.get("Poster");
        model.addAttribute("Title", title_Element.getAsString());
        model.addAttribute("Year", year_Element.getAsString());
        model.addAttribute("Plot", plot_Element.getAsString());
        model.addAttribute("Poster", poster_eleElement.getAsString());
        return "movie";
    }
}
