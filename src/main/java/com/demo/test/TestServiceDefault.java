package com.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "prod"})
public class TestServiceDefault implements TestService {
	
	@Value("${test.string}")
	private String testString;

	@Override
	public String getString() {

		return testString;
	}
	
}
