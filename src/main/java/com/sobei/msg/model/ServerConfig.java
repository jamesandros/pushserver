package com.sobei.msg.model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 服务器配置
 * 
 * @author andros
 *
 *         2015年7月1日下午12:16:53
 */
public class ServerConfig {
	/**
	 * ip
	 */
	private String ip;
	/**
	 * 端口
	 */
	private int port;
	/**
	 * 服务器名称
	 */
	private String serverName;
	/**
	 * 认证key
	 */
	private String authKey;
	/**
	 * 服务器id
	 */
	private int serverId;
	/**
	 * 交换机实例名
	 */
	private String exchange;
	/**
	 * 队列名
	 */
	private String queueName;
	/**
	 * 最大客户端连接数
	 */
	private int maxClientTotal;
	/**
	 * 是否性能监控
	 */
	private boolean openProfileMonitor;
	/**
	 * 是否生产环境
	 */
	private boolean isProductEnv;

	
	private static ServerConfig instance = null;

	public ServerConfig() {
		instance = this;
	}

	public static ServerConfig getInstance() {
		return instance;
	}
	public static void setInstance(ServerConfig inst) {
		if (instance == null)
			instance = inst;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public boolean isOpenProfileMonitor() {
		return openProfileMonitor;
	}

	public void setOpenProfileMonitor(boolean openProfileMonitor) {
		this.openProfileMonitor = openProfileMonitor;
	}

	public boolean isProductEnv() {
		return isProductEnv;
	}

	public void setProductEnv(boolean isProductEnv) {
		this.isProductEnv = isProductEnv;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public int getMaxClientTotal() {
		return maxClientTotal;
	}

	public void setMaxClientTotal(int maxClientTotal) {
		this.maxClientTotal = maxClientTotal;
	}
	
}
