package com.sobei.msg.common;

/**
 * 全局公共常量
 * 
 * @author andros
 *
 *         2015年6月26日下午2:40:33
 */
public class Constant {
	public static final int SO_TIMEOUT = 60000;

	public static final int CONNECTION_TIMEOUT = 60000;
	/**
	 * 超时时间，单位秒
	 */
	public static int DEFAULT_TIMEOUT = 5;

	/**
	 * 缓存时效 1小时
	 */
	public static final int CACHE_EXP_HOUR = 3600;

	/**
	 * 缓存时效 1天
	 */
	public static final int CACHE_EXP_DAY = 3600 * 24;

	/**
	 * 缓存时效 1周
	 */
	public static final int CACHE_EXP_WEEK = 3600 * 24 * 7;

	/**
	 * 缓存时效 1月
	 */
	public static final int CACHE_EXP_MONTH = 3600 * 24 * 30;

	/**
	 * 时间间隔一天
	 */
	public static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	/**
	 * 时间时隔1分钟
	 */
	public static final long PERIOD_MIN = 60 * 1000;
	/**
	 * 缓存时效 永久
	 */
	public static final int CACHE_EXP_FOREVER = 0;
	/**
	 * 缓存常量名
	 */
	public static final String REDIS_CACHED = "REDIS_CACHED";

}
