package com.sobei.msg.common;
import java.util.Properties;

import com.sobei.msg.util.PropsUtil;

/**
 * 
 * @author andros
 *
 * 2015年6月19日上午11:20:28
 */
public class PropertiesConfig {
	private static final Properties config = PropsUtil.loadProps("config") ;
	public static Properties getConfig() {
		return config;
	}
}
