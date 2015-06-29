package com.sobei.msg.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender04 {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connFac = new ConnectionFactory();
		
		// RabbitMQ-Server安装在本机，所以直接用127.0.0.1
		connFac.setHost("127.0.0.1");

		// 创建一个连接
		Connection conn = connFac.newConnection();

		// 创建一个渠道
		Channel channel = conn.createChannel();

		String exchangeName = "news";
		channel.exchangeDeclare(exchangeName, "fanout");
		String msg = "hello wolrd : haha";
		//第二个参数是消息类型
		channel.basicPublish(exchangeName, "", null, msg.getBytes());
		System.out.println("send message[" + msg + "] to exchange "
				+ exchangeName + " success!");
		channel.close();
		conn.close();

	}
}
