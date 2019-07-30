package com.demo.mock;

import org.springframework.stereotype.Service;

@Service
public class TestServiceCaller {
	
	private TestMockService testMockService;
	
	public TestServiceCaller(TestMockService testMockService) {
		this.testMockService = testMockService;
	}
	
	public String execute() {
		return testMockService.execute();
	}
}
