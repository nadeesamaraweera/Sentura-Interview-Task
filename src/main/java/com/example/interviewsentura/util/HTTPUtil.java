package com.example.interviewsentura.util;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class HTTPUtil {
    private final OkHttpClient client = new OkHttpClient();

        public String get(String url, String token) throws IOException {
            Request request = new Request.Builder().url(url).addHeader("Authorization", token).build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }

        public String post(String url, String json, String token) throws IOException {
            RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
            Request request = new Request.Builder().url(url).post(body).addHeader("Authorization", token).build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }

        public String put(String url, String json, String token) throws IOException {
            RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
            Request request = new Request.Builder().url(url).put(body).addHeader("Authorization", token).build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }

        public String delete(String url, String token) throws IOException {
            Request request = new Request.Builder().url(url).delete().addHeader("Authorization", token).build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }
    }
