package com.sobei.msg.util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * @author andros
 *
 * 2015年6月29日下午12:12:14
 */
public class SpringContextUtil implements ApplicationContextAware{
	    private static ApplicationContext applicationContext;
	    /**
	     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	     */
	    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
	        SpringContextUtil.applicationContext = applicationContext;
	    }
	    public static ApplicationContext getApplicationContext() {
	        return applicationContext;
	    }
	    @SuppressWarnings("unchecked")
		public static <T> T getBean(String beanId){
	        return (T)applicationContext.getBean(beanId);
	    }
}
