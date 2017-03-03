package com.apress.isf.spring.service;
/*
 * dirkseActive  2/13/2017  Chapter 7 Introducing Spring Framework
 */

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;

@Component
@Profile("qa")

public class FileSearchEngineService implements SearchEngine {

	@Override
	public List<Document> findByType(Type documentType) {
		throw new UnsupportedOperationException("QA Environment.  Not yet implemented operation.");
	}

	@Override
	public List<Document> listAll() {
		throw new UnsupportedOperationException("QA Environment.  Not yet implemented operation.");
	}

	@Override
	public List<Document> findByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
