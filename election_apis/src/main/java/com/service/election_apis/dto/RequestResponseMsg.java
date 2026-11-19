package com.service.election_apis.dto;

public class RequestResponseMsg {

	private Integer statusCode;
	private String message;
	
	
	public RequestResponseMsg(Integer statusCode, String message) {
		//super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
