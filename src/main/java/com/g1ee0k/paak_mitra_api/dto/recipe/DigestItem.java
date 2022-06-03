package com.g1ee0k.paak_mitra_api.dto.recipe;

import lombok.Data;

import java.util.List;

@Data
public class DigestItem{
	private String schemaOrgTag;
	private double total;
	private String unit;
	private double daily;
	private boolean hasRDI;
	private String label;
	private String tag;
	private List<SubItem> sub;
}