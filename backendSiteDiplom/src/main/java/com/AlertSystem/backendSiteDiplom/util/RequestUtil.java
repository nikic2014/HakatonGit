package com.AlertSystem.backendSiteDiplom.util;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestUtil {
    public String sendRequest(){
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.example.com/data";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            System.out.println(responseData);

            return responseData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "We have truble";
    }

}
