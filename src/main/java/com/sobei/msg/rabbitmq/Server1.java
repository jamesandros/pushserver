package com.sobei.msg.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Server1 {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory conFactory = new ConnectionFactory();
		conFactory.setHost("127.0.0.1");
		Connection conn = conFactory.newConnection();
		Channel channel = conn.createChannel();
		String queName = "que1";
		channel.queueDeclare(queName, false, false,false,null);
		String msg = "hello world";
		channel.basicPublish("", queName, null, msg.getBytes());
		System.out.println("sendmessage["+msg+"] to " + queName + "success!");
		channel.close();   
        conn.close();   
		
	}
}
