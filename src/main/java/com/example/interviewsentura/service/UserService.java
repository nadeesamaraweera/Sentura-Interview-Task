package com.example.interviewsentura.service;

import com.example.interviewsentura.config.WeavyConfig;
import com.example.interviewsentura.util.HTTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONArray;

@Service
public class UserService {

    @Autowired
    private HTTPUtil httpUtil;

    @Autowired
    private WeavyConfig weavyConfig;

    public String createUser(String userJson) throws IOException {
        return httpUtil.post(weavyConfig.getWeavyApiUrl(), userJson, weavyConfig.getWeavyApiToken());
    }

    public String listUsers() throws IOException {
        String response = httpUtil.get(weavyConfig.getWeavyApiUrl(), weavyConfig.getWeavyApiToken());

        JSONObject jsonResponse = new JSONObject(response);

        JSONArray usersArray = jsonResponse.getJSONArray("data");

        return usersArray.toString();
    }

    public String getUser(String userId) throws IOException {
        return httpUtil.get(weavyConfig.getWeavyApiUrl() + "/" + userId, weavyConfig.getWeavyApiToken());
    }

    public String updateUser(String userId, String userJson) throws IOException {
        return httpUtil.put(weavyConfig.getWeavyApiUrl() + "/" + userId, userJson, weavyConfig.getWeavyApiToken());
    }

    public String deleteUser(String userId) throws IOException {
        return httpUtil.delete(weavyConfig.getWeavyApiUrl() + "/" + userId, weavyConfig.getWeavyApiToken());
    }
}
