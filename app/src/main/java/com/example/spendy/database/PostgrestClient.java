package com.example.spendy.database;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;

public class PostgrestClient {
    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final Gson gson;

    public PostgrestClient(OkHttpClient httpClient, String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl + "/rest/v1";
        this.gson = new Gson();
    }

    public PostgrestFilterBuilder from(String table) {
        return new PostgrestFilterBuilder();
    }
}
