package com.sobei.msg.util.cache;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sobei.msg.common.Log;


public class Client {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JedisTemplate template = app.getBean("redisTemplate",JedisTemplate.class);
		
		
//		for(int i = 0;i < 100000;i++){
//			
//			template.setex(UUID.randomUUID()+":user"+i, "", 5000);
//		}
		//template.setex(UUID.randomUUID()+":user88634", "", 5000);
		long start = System.currentTimeMillis();
		Set<String> s = template.keys("73bf31f3-0f03-4146-92a8-df5e45305e5a:user88634");
		System.out.println("end"+(System.currentTimeMillis()-start));
		Iterator<String> it =  s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Log.getCommon().debug("开始创建hessianBean");
		//template.keys("")
		
		//template.opsForHash().put("AAAA","213", "123");
		//System.out.printlnopsForList(template);
		
	}
}
