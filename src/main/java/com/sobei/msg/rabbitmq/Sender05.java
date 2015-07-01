package com.sobei.msg.rabbitmq;

import java.io.IOException;
import java.util.Date;

import com.rabbitmq.client.BlockedListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;

public class Sender05 {
	public static final String SERVERID = "server1";
	public static final String EXCHANGE_NAME = "IM";
	public static void main(String[] args) throws Exception {

		ConnectionFactory connFac = new ConnectionFactory();
		connFac.setHost("127.0.0.1");
		Connection conn = connFac.newConnection();
		conn.addShutdownListener(new ShutdownListener() {
			public void shutdownCompleted(ShutdownSignalException connection) {
				System.out.println("挂掉了");
			}
		});
		Channel channel = conn.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		channel.queueDeclare("quenu" , false, false, false, null) ;  
		channel.queueBind("quenu", EXCHANGE_NAME, SERVERID);
		String message = new Date().toString()+":quenu";
		channel.basicPublish(EXCHANGE_NAME, SERVERID, null, message.getBytes());
		
//		while(true){
//			channel.basicPublish(EXCHANGE_NAME, SERVERID, null, message.getBytes());
//			Thread.sleep(1000*5);
//		}
		
		channel.close();
		conn.close();
		
	}
}
