package com.rest.ems.dto;

public class Response {

	private String responseMsg;
	private int responseCode;

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Response(String responseMsg, int responseCode) {
		super();
		this.responseMsg = responseMsg;
		this.responseCode = responseCode;
	}

}
