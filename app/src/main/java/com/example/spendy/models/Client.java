package com.example.spendy.models;

import com.example.spendy.database.PostgrestClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Client {
    private final String supabaseUrl;
    private final String supabaseKey;
    private final OkHttpClient httpClient;
    private final PostgrestClient postgrestClient;

    public Client(String supabaseUrl, String supabaseKey) {
        this.supabaseUrl = supabaseUrl;
        this.supabaseKey = supabaseKey;
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("apikey", supabaseKey)
                            .header("Authorization", "Bearer " + supabaseKey)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .build();
        this.postgrestClient = new PostgrestClient(httpClient, supabaseUrl);
    }

    public PostgrestClient getPostgrest() {
        return postgrestClient;
    }
}
