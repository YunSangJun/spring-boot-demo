package com.demo.user.service;

import java.util.List;

import com.demo.user.domain.User;

public interface UserService {

	List<User> selectAll();
	
	User selectById(int id);
	
	int insert(User user);
	
	int update(User user);
	
	int delete(int id);
	
	void updateWithError(User user);
	
}
