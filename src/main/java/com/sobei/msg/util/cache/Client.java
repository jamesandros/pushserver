package com.sobei.msg.util.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;


public class Client {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate template = app.getBean("redisTemplate", RedisTemplate.class);
		template.opsForHash().put("AAAA","213", "123");
		
	}
}
