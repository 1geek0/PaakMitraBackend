package com.g1ee0k.paak_mitra_api.controller;

import com.g1ee0k.paak_mitra_api.dto.recipe.RecipeResponse;
import com.g1ee0k.paak_mitra_api.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public RecipeResponse findRecipes(@RequestParam String q) {
        return recipeService.findRecipes(q);
    }
}
