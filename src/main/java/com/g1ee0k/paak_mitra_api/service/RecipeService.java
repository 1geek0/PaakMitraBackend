package com.g1ee0k.paak_mitra_api.service;

import com.g1ee0k.paak_mitra_api.dto.recipe.RecipeRequest;
import com.g1ee0k.paak_mitra_api.dto.recipe.RecipeResponse;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Component
@Service
public class RecipeService {
    private final String BASE_URL = "https://api.edamam.com/api/recipes/v2";

    private Gson gson = new Gson();

    private final Request.Builder request = new Request.Builder().addHeader("Content-Type", "application/json");
    private final OkHttpClient client = new OkHttpClient();

    public RecipeResponse findRecipes(String query) {
        RecipeRequest recipeRequest = new RecipeRequest(query);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), gson.toJson(recipeRequest));
        String url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.edamam.com")
                .addPathSegment("api")
                .addPathSegment("recipes")
                .addPathSegment("v2")
                .addQueryParameter("q", query)
                .addQueryParameter("beta", "true")
                .addQueryParameter("type", "public")
                .addQueryParameter("app_key","f0772ab0")
                .addQueryParameter("app_id", "3c584ee9266854b71be156a9304cc47b")
                .addQueryParameter("cuisineTypes", "Indian,Italian,Chinese").build().toString();
        Request req =new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(req).execute();
            if (response.body() != null) {
                return gson.fromJson(response.body().string(), RecipeResponse.class);
            } else {
                throw new RuntimeException("Invalid Response from Server");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
