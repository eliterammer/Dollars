package com.trendanora.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.trendanora.datacatalog.Category;
import com.trendanora.repository.CategoryDataRepository;

public final class BeanFactory {

	 private BeanFactory() {
	 }

	  public static <T> T createBean(final Class<T> beanClass) {
	    	
	    	
	    	DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
	    	GenericApplicationContext parentContext = new GenericApplicationContext(parentBeanFactory);
	    	parentContext.refresh();    	
	    	
	    	ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:services-context.xml"}, parentContext);    	        
	    	return ctx.getBeanFactory().createBean(beanClass);    	
	    } 

	
}
