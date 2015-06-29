package com.sobei.msg.util.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;


public class Client {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JedisTemplate template = app.getBean("redisTemplate",JedisTemplate.class);
		
		template.set("key", "zzzz");
		
		//template.opsForHash().put("AAAA","213", "123");
		//System.out.printlnopsForList(template);
		
	}
}
