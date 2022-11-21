package com.rest.ems.dto;

public class Response {

	private String errorMsg;
	private int errorCode;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Response(String errorMsg, int errorCode) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

}
