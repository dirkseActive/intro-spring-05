package com.apress.isf.spring.test;

import java.util.Locale;

import static java.lang.System.out;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDocumentsIL8nTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsIL8nTest.class);
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-il8n-context.xml");
	}
	
	@Test
	public void testMenu(){
		log.debug("About to Translate...");
		String english = context.getMessage("main.title", null, Locale.ENGLISH);
		String spanish = context.getMessage("main.title", null, new Locale("es"));
		out.println("English: " + english);
		out.println("Spanish: " + spanish);
	}

}
