package com.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	private TestService testService;
	
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
	
	@RequestMapping("/error")
	public String error() {
		throw new RuntimeException("error");
	}
	
}
