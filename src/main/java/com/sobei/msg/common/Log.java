package com.sobei.msg.common;

import org.apache.log4j.Logger;

/**
 * 
 * @author andros
 *
 * 2015年6月26日下午2:23:55
 */
public class Log{
	//公共模块日志
	private static Logger common = Logger.getLogger("common");
	//缓存日志
	private static Logger cache = Logger.getLogger("cache");
	
	public static Logger getCommon() {
		return common;
	}
	public static Logger getCache() {
		return cache;
	}
}
