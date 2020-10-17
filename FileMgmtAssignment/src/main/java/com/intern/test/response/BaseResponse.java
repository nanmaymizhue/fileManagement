package com.intern.test.response;

public class BaseResponse {

	int errorCode;
	Object result;
	String message;
	public BaseResponse(int errorCode, Object result, String message) {
		super();
		this.errorCode = errorCode;
		this.result = result;
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
