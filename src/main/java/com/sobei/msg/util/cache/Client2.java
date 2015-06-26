package com.sobei.msg.util.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Client2 {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate template = app.getBean("redisTemplate", RedisTemplate.class);
		String s =(String)template.opsForHash().get("123", "yizhixinghash");
		System.out.println(s);
	}
}
