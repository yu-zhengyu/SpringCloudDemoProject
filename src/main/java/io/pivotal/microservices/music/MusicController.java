package io.pivotal.microservices.music;

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
public class MusicController {
    protected Logger logger = Logger.getLogger(MusicController.class.getName());
    
    @RequestMapping("/music")
    public String goHome(Model model) {
        model.addAttribute("index");
        return "index";
    }
    
    @RequestMapping("/music/{name}")
    public String byName(@PathVariable("name") String name) {
        String url = "http://api.onemusicapi.com/20151208/artist?user_key=030562ae55909f815c73a27290dc9525&called=" + name;
        url = url.replaceAll(" ", "%20");
        System.out.println(url);
        String result = sendGet(url);
        return result;
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
