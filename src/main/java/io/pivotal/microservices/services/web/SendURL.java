package io.pivotal.microservices.services.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhengyu
 * @date 2016年4月26日
 */
public class SendURL {
    public static String sendGet(String url) {
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
