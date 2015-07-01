package com.sobei.msg.core;

/**
 * 负责专门消费消息的类
 * @author andros
 *
 * 2015年7月1日下午4:56:38
 */
public class MessageConsume extends Thread {
	public void init(){
		MQConnectionManager manager = MQConnectionManager.getInstance();
	}
	public void run(){
		init();
		while(true){
			
		}
	}
}
