package com.acc.brand.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PSearch {
	
	@JsonProperty("P_SEARCH")
	private String psearch;
	
    public String getPsearch() {
        return psearch;
    }

    public void setPsearch(String psearch) {
        this.psearch = psearch;
    }

}
