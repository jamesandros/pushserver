package com.sobei.msg.model;

import java.io.Serializable;

public class UserSession implements Serializable {

	private static final long serialVersionUID = -420654276443130425L;
	
	/**
	 * 用户唯一标示 与 clientid 一致
	 */
	private String uuidkey;
	
	/**
	 * 系统账户可以给别人发送消息。匿名账户无法点对点。只能接收消息推送
	 * 用户名称。弱存在系统则系统用户。否则分配匿名账户
	 */
	private String username;
	
	/**
	 * 用户所在服务器列表
	 */
	private String serverId;
	
	
}
