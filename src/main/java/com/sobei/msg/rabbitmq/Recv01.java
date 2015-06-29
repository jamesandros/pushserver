package com.sobei.msg.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class Recv01 {
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		ConnectionFactory connFac = new ConnectionFactory() ;  
        
        connFac.setHost("127.0.0.1");  
          
        Connection conn = connFac.newConnection() ;  
          
        Channel channel = conn.createChannel() ;  
        
        String queueName = "que1";  
        
        //队列定义
        channel.queueDeclare(queueName, false, false, false, null) ;  
          
        //上面的部分，与Sender01是一样的  
          
        //配置好获取消息的方式  
        QueueingConsumer consumer = new QueueingConsumer(channel) ; 
        
        channel.basicConsume(queueName, true, consumer) ;  
        
        while(true){  
            
            //获取消息，如果没有消息，这一步将会一直阻塞  
            Delivery delivery = consumer.nextDelivery() ;  
              
            String msg = new String(delivery.getBody()) ;    
              
            System.out.println("received message[" + msg + "] from " + queueName);  
        }  
	}
}
