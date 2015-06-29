package com.sobei.msg.util.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Client2 {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		JedisTemplate template = app.getBean("redisTemplate",JedisTemplate.class);
		
		System.out.println(template.get("key"));
	}
}
