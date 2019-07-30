package com.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.dao.UserMapper;
import com.demo.user.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		
		logger.debug("{}", userMapper != null);
	}
	
	@Test
	public void selectAll() {
		
		List<User> users = userMapper.selectAll();
		
		for(User user:users) {
			logger.debug("{}", user);
		}
	}
	
	@Test(expected = DuplicateKeyException.class)
	public void create() {
		
		assertThat(userMapper.selectAll().size(), is(1));
		
		User newUser = new User();
		newUser.setAge(18);
		newUser.setId(1);
		newUser.setName("Test");
		userMapper.insert(newUser);
		
		assertThat(userMapper.selectAll().size(), is(2));
		
		userMapper.insert(newUser);
	}

}
