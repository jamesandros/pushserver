package com.sobei.msg.rabbitmq;

import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Recv04_01 {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connFac = new ConnectionFactory();

		connFac.setHost("127.0.0.1");

		Connection conn = connFac.newConnection();

		Channel channel = conn.createChannel();

		String exchangeName = "news";
		channel.exchangeDeclare(exchangeName, "fanout");
		// 默认获得队列
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, exchangeName, "");
		
		QueueingConsumer consumer = new QueueingConsumer(channel) ;  
        channel.basicConsume(queueName, true, consumer) ;  
        while(true){  
            
            //获取消息，如果没有消息，这一步将会一直阻塞  
            Delivery delivery = consumer.nextDelivery() ;  
              
            String msg = new String(delivery.getBody()) ;    
              
            System.out.println("received message[" + msg + "] from " + queueName + "-" + new Date(System.currentTimeMillis()));  
        }  
	}
}
