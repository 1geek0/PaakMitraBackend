package com.g1ee0k.paak_mitra_api.dto.recipe;

import lombok.Data;

@Data
public class IngredientsItem{
	private String image;
	private double quantity;
	private String measure;
	private String foodId;
	private double weight;
	private String text;
	private String foodCategory;
	private String food;
}