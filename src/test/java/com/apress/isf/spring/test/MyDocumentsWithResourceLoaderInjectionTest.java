package com.apress.isf.spring.test;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDocumentsWithResourceLoaderInjectionTest {
	private static final Logger log = 
			LoggerFactory.getLogger(MyDocumentsWithResourceLoaderInjectionTest.class);
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setup(){
		context = new 
				ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
	}

}
