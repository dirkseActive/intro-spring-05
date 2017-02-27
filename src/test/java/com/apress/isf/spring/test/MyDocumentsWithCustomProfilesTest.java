package com.apress.isf.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.test.profile.CustomProfile;

/*
 * dirkseActive 2/14/2017 Chap 7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration("classpath:META-INF/spring/mydocuments-custom-profiles-context.xml")
@ProfileValueSourceConfiguration(CustomProfile.class)
@TestExecutionListeners(listeners = {ServletTestExecutionListener.class, TransactionalTestExecutionListener.class,DependencyInjectionTestExecutionListener.class,
	    DirtiesContextTestExecutionListener.class})
public class MyDocumentsWithCustomProfilesTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithCustomProfilesTest.class);
	
	@Autowired
	private SearchEngine engine;
	@Autowired
	private Type webType;
	
	@IfProfileValue(name = "environment", values = "dev")
	@Test
	public void testUsingSpringTestWithCustomPriflesX(){
		try{
			log.debug("Using Spring Test fixtures:");
			
			List<Document> documents = engine.findByType(webType);
			assertNotNull(documents);
			assertTrue(documents.size() == 1);
			assertEquals(webType.getName(),documents.get(0).getType().getName());
			assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
			assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
			
			documents = engine.listAll();
			assertNotNull(documents);
			assertTrue(documents.size() == 4);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		}
	
	@IfProfileValue(name = "os.name", values = "Unix")
	@Test
	public void testUsingSpringTestWithCustomPrfilesY(){
		try{
			log.debug("Using Spring Test fixtures on Unix:");
			// More testing
		}catch(Exception ex){
			log.error(ex.getMessage());
		}
	}
}

