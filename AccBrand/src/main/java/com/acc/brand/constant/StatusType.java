package com.acc.brand.constant;

public enum StatusType {
	RESULT_SUCCESS("T", "Success"),
	RESULT_FAILED("F", "invalid input"),
	AUTHORIZATION_FAILED("F", "You do not have permission to access the API!");
	
	private String code;
	private String message;
	
	private StatusType(String code, String message) {
		this.code=code;
		this.message=message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
}
