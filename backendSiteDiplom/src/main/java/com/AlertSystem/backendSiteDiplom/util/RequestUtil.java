package com.AlertSystem.backendSiteDiplom.util;


import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestUtil {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public String sendCreateRepo(String username, int course_id, String course_name, String decription) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Замените значения username, course_id, course_name и description на соответствующие значения
        String json = "{\"username\":\"" + username +
                "\", \"course_id\":"+course_id +
                ", \"course_name\":\""+course_name+"\", " +
                "\"description\":\""+decription+"\"}";

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8000/create_repository")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responce = response.body().string();
            return responce;
        }
    }

    public String sendInfoToPush(String username, String infoToRep, String branchName) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Замените значения username, course_id, course_name и description на соответствующие значения
        String json = "{\"username\":\"" + username +
                "\", \"repository_url\":"+infoToRep +
                ", \"branch_name\":\""+branchName+"\"}";

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8000/get_branch_info")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responce = response.body().string();
            return responce;
        }
    }
}
