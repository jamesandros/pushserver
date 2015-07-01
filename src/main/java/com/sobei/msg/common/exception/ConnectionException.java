package com.sobei.msg.common.exception;

/**
 * 
 * @author andros
 *
 * 2015年7月1日下午4:35:12
 */
public class ConnectionException  extends Exception {
	private static final long serialVersionUID = 4633105834973514891L;
	public ConnectionException(String message){
		super(message);
	}
	
	public ConnectionException(Throwable throwable){
		super(throwable);
	}
	
	public ConnectionException(String message,Throwable throwable){
		super(message, throwable);
	}
}
