package com.sobei.msg.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BlockedListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;

public class Recv05 {
	public static final String SERVERID = "serverB";
	public static final String EXCHANGE_NAME = "IM";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		Connection connection = factory.newConnection();
		connection.addShutdownListener(new ShutdownListener() {
			public void shutdownCompleted(ShutdownSignalException connection) {
				System.out.println("挂掉了");
			}
		});
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "direct"/* exchange类型 */);
		// 创建匿名Queue
		// String queueName = channel.queueDeclare().getQueue();
		// 订阅某个关键词，绑定到匿名Queue中
		channel.queueBind("quenu", EXCHANGE_NAME, SERVERID);
		
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("quenu", true, consumer);
		QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		String message = new String(delivery.getBody());
		String routingKey = delivery.getEnvelope().getRoutingKey(); // 可获取路由关键词
		System.out.println(message + ":" + routingKey);
		// while(true){
		// QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		// String message = new String(delivery.getBody());
		// String routingKey = delivery.getEnvelope().getRoutingKey(); //
		// 可获取路由关键词
		// System.out.println(message+":"+routingKey);
		// }
		// Blocking...
		channel.close();
		connection.close();
	}
}
