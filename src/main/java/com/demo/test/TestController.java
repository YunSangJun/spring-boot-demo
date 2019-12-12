package com.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/test")
public class TestController {

	private TestService testService;
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	public TestController(TestService testService) {
		this.testService = testService;
	}
	
	/*
	 * /test/string
	 */
	@RequestMapping("/string")
	public String getString() {
		return testService.getString();
	}

	@RequestMapping(path = "/big/{count}", method = RequestMethod.GET)
	public void printBigLog(@PathVariable("count") int count) {

		String resultStr = "";

		for(int i=0; i<count; i++){
			resultStr = resultStr + "A";
		}

		logger.info("length: " + count + ", log: " + resultStr);
	}
	
	@RequestMapping("/error")
	public String error() {
		throw new RuntimeException("error");
	}
	
}
