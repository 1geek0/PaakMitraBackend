package com.g1ee0k.paak_mitra_api.dto.recipe;

import lombok.Data;

@Data
public class SubItem{
	private String schemaOrgTag;
	private double total;
	private String unit;
	private double daily;
	private boolean hasRDI;
	private String label;
	private String tag;
}