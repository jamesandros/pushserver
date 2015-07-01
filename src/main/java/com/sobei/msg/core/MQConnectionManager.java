package com.sobei.msg.core;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.Queue.DeleteOk;
import com.sobei.msg.common.Log;
import com.sobei.msg.util.ObjectUtil;

/**
 * 
 * @author andros
 *
 * 2015年7月1日下午5:50:56
 */
public class MQConnectionManager {
	private Connection connection = null;
	private Channel channel = null;

	static class Inner {
		static MQConnectionManager connectionManager = new MQConnectionManager();
	}

	public static MQConnectionManager getInstance() {
		return Inner.connectionManager;
	}

	private Connection getConnection() { // 建立连接方法
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try {
			connection = connectionFactory.newConnection();
		} catch (IOException | TimeoutException e) {
			Log.getCommon().error("链接创建失败", e);
		}
		return connection;
	}

	private Channel getChannel(Connection conn) {
		try {
			channel = conn.createChannel();
		} catch (IOException e) {
			Log.getCommon().error("通道建立失败", e);
		}
		return channel;
	}

	public void closeAll() { // 关闭连接
		try {
			if (ObjectUtil.objIsNotNull(channel) || channel.isOpen()) {
				channel.close();
				if (ObjectUtil.objIsNotNull(connection) || connection.isOpen()) {
					connection.close();
				}
			}
		} catch (Exception e) {
			Log.getCommon().error("关闭链接出现异常", e);
		}

	}

	/**
	 * 创建队列
	 * 
	 * @param exchangeName
	 * @param queueName
	 * @param mode
	 */
	public Channel createQueue(String exchangeName, String queueName, String mode) {
		Connection conn = getConnection();
		Channel channel = getChannel(conn);
		try {
			channel.exchangeDeclare(exchangeName, mode);
			channel.queueDeclare(queueName, false, false, false, null);	
		} catch (IOException e) {
			Log.getCommon().error("创建队列失败", e);
		}
		return channel;
	}

	/**
	 * 销毁队列
	 * 
	 * @param queueName
	 * @return
	 */
	public boolean destoryQueue(String queueName) {
		try {
			DeleteOk ok = channel.queueDelete(queueName);
			if (ok.getMessageCount() > 0) {
				return true;
			}
		} catch (IOException e) {
			Log.getCommon().error("销毁队列异常", e);
		}
		return false;
	}

}