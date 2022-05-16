package com.acc.brand.response;

import com.acc.brand.constant.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAcc<T> {
	
	@JsonProperty("OUT_STAT")
	private String outStat;
	
	@JsonProperty("OUT_MESS")
	private String outMess;
	
	@JsonProperty("OUT_DATA")
	private T outData;
	
	public static <T> ResponseAcc<T> buildResponse(T outData, String outStat, String outMess){
		ResponseAcc<T> response = new ResponseAcc<>();
		response.setOutData(outData);
		response.setOutMess(outMess);
		response.setOutStat(outStat);
		return response;
		
	}

	   public String getOutStat() {
	        return outStat;
	    }

	    public void setOutStat(String outStat) {
	        this.outStat = outStat;
	    }

	    public String getOutMess() {
	        return outMess;
	    }

	    public void setOutMess(String outMess) {
	        this.outMess = outMess;
	    }

	    public T getOutData() {
	        return outData;
	    }

	    public void setOutData(T outData) {
	        this.outData = outData;
	    }
	    
}
