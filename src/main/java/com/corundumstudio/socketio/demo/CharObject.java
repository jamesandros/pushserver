package com.corundumstudio.socketio.demo;

public class CharObject {
	private String userName;
	private String message;
	public CharObject(){}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CharObject [userName=" + userName + ", message=" + message
				+ "]";
	}
	
}
