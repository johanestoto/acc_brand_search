package com.acc.brand.json.result;

import javax.persistence.Column;

import com.acc.brand.model.Brand;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandResult {
	@JsonProperty("CD_BRAND")
	private String cdBrand;
	
	@JsonProperty("DESC_BRAND")
	private String descBrand;
	
	public BrandResult(String cdBrand, String descBrand) {
		this.cdBrand=cdBrand;
		this.descBrand=descBrand;
	}
	
    public String getCdBrand() {
        return cdBrand;
    }

    public void setCdBrand(String cdBrand) {
        this.cdBrand = cdBrand;
    }

    public String getDescBrand() {
        return descBrand;
    }

    public void setDescBrand(String descBrand) {
        this.descBrand = descBrand;
    }
    
 
    
}
