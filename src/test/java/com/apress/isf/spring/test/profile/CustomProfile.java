package com.apress.isf.spring.test.profile;

import org.springframework.test.annotation.ProfileValueSource;

/*
 * dirkseActive 2/13/2017 Intro Spring
 */
public class CustomProfile implements ProfileValueSource{
	
	public String get(String key){
		if(key.equals("dev"))
				return "Development";
		else if (key.equals("qa"))
			return "QA";
		return null;
	}

}
