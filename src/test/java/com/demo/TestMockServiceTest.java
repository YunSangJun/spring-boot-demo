package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.mock.mockito.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import com.demo.mock.TestMockService;
import com.demo.mock.TestServiceCaller;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMockServiceTest {

	@MockBean
	private TestMockService testMockService;
	
	@Autowired
	private TestServiceCaller testServiceCaller;
	
	@Test
	public void test() {
		
		String result = "Mocking Test";
		
		given(testMockService.execute()).willReturn(result);
		
		assertThat(testServiceCaller.execute()).isEqualTo(result);
		
	}
	
}
