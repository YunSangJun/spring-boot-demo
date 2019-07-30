package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebEnviromentTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	String testString;
	
	@Test
	public void contextLoads() {
		String result = testRestTemplate.getForObject("/env", String.class);
		logger.debug("{}", result);
	}
	
	@Test
	public void stringTest() {
		logger.debug("{}", testString);
	}
	
	@TestConfiguration
	static class WebEnviromentTestConfiguration{
		
		@Bean
		public String testString() {
			return "String from WebEnviromentTestConfiguration";
		}
		
	}

}
