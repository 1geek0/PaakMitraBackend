package com.g1ee0k.paak_mitra_api.dto.recipe;

import java.util.List;
import lombok.Data;

@Data
public class RecipeResponse{
	private List<HitsItem> hits;
}