package com.g1ee0k.paak_mitra_api.dto.recipe;

import java.util.List;
import lombok.Data;

@Data
public class Recipe{
	private String image;
	private String shareAs;
	private Images images;
	private List<String> cautions;
	private List<String> healthLabels;
	private String co2EmissionsClass;
	private double totalTime;
	private List<String> mealType;
	private String label;
	private String source;
	private double calories;
	private double totalCO2Emissions;
	private List<String> cuisineType;
	private String uri;
	private String url;
	private TotalNutrients totalNutrients;
	private List<String> dietLabels;
	private List<String> dishType;
	private double yield;
	private double totalWeight;
	private List<DigestItem> digest;
	private List<IngredientsItem> ingredients;
	private TotalDaily totalDaily;
	private List<String> ingredientLines;
}