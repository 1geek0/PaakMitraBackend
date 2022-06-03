package com.g1ee0k.paak_mitra_api.dto.recipe;

import lombok.*;

@Data
@RequiredArgsConstructor
public class RecipeRequest {
    private String type = "public";
    private String beta = "true";
    @NonNull
    private String q;
    private String app_key = System.getProperty("EDAMAM_APP_KEY");
    private String app_id = System.getProperty("EDAMAM_APP_ID");
    private String[] cuisineTypes = new String[]{"Indian", "Italian", "Chinese"};
}
