package com.sobei.msg.core;

import java.io.IOException;

import com.rabbitmq.client.AMQP.Queue.DeleteOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;
import com.sobei.msg.common.Log;
import com.sobei.msg.common.exception.ConnectionException;
import com.sobei.msg.model.ServerConfig;

/**
 * 消息提供者
 * @author andros
 *
 * 2015年7月1日下午4:52:41
 */
public class MessageProvider extends Thread {
	
	private Channel channel = null;
	public void init(){
		MQConnectionManager manager = MQConnectionManager.getInstance();
		channel =manager.createQueue("exchange", "bbb", "direct");
		try {
			channel.queueBind("bbb", "exchange", "zzz");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage(String destQueue,String id,Object object){
		//channel.basicPublish(exchange, routingKey, props, body);
	}
	
	public void consumeMessage(String destQueue,String id,Object object) throws Exception{
		QueueingConsumer consumer = new QueueingConsumer(channel);
		try {
			channel.basicConsume("destQueue", true, consumer);
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
