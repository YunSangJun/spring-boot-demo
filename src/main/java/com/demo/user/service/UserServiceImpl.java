package com.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.user.dao.UserMapper;
import com.demo.user.domain.User;

//"userService" is name of bean
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public User selectById(int id) {
		return userMapper.selectById(id);
	}

	@Override
	public int insert(User user) {
		int result = userMapper.insert(user);
		
		if (result != 1) {
			throw new RuntimeException("Insert error.");
		} 
		
		return result;
	}

	@Override
	public int update(User user) {
		int result = userMapper.update(user);
		
		if (result != 1) {
			throw new RuntimeException("Update error.");
		}
		
		return result;
	}

	@Override
	public int delete(int id) {
		int result = userMapper.delete(id);
		
		if (result != 1) {
			throw new RuntimeException("Delete error.");
		}
		
		return result;
	}

	@Transactional(noRollbackFor = RuntimeException.class)
	@Override
	public void updateWithError(User user) {
		userMapper.update(user);
		throw new RuntimeException("Update with error.");
	}
	
	

}
