package com.sobei.msg.common.exception;

/**
 * 
 * @author andros
 *
 * 2015年6月26日下午2:38:54
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID = -1116403048941696425L;
	
	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(Throwable throwable){
		super(throwable);
	}
	
	public BusinessException(String message,Throwable throwable){
		super(message, throwable);
	}
}
