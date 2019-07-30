package com.demo.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.domain.User;
import com.demo.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
	public List<User> selectAll(){
		return userService.selectAll();
		
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public User selectById(@PathVariable("id") int id) {
		return userService.selectById(id);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void insert(@RequestBody User user) {
		userService.insert(user);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void update(@RequestBody User user) {
		userService.update(user);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		userService.delete(id);
	}
}
