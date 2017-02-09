/**
 * 
 */
package com.apress.isf.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;

// import com.apress.isf.java.model.Document;
// import com.apress.isf.java.model.Type;
// import com.apress.isf.java.service.SearchEngine;

/**
 * @author bvs
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	
	@Autowired
	private SearchEngine engine;
	
	@Autowired
	private Type webType;
	
//	private ClassPathXmlApplicationContext context;
	
//	private SearchEngine engine;
//	private Type webType;
	
//	@Before
//	public void setup(){
//		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
//	}
	
	@Test
	public void testUsingSpringTest() {	
		log.debug("Using Spring Text figures:");
		
		List<Document> documents = engine.findByType(webType);
		
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());

		documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
/**		
		
		Resource resource = context.getResource("classpath:META-INF/data/menu.txt");
		try{
			InputStream stream = resource.getInputStream();
			Scanner scanner = new Scanner(stream);
			while(scanner.hasNext()){
				System.out.println(scanner.next());
			}
			scanner.close();
			stream.close();
		} catch(IOException e){
			e.printStackTrace();
		}
**/	
		/**
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean("webType",Type.class);
		
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		engine = context.getBean(SearchEngine.class);
		
		documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
		**/
	}
}
