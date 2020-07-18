package com.lms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.User;
import com.lms.util.DBUtil;

@RestController
public class UserController {

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserList(){
		List<User> list = DBUtil.generateUserList();
		ResponseEntity<List<User>> entity = new ResponseEntity<List<User>>(list,HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/users/authenticate")
	public User authenticateUser(@RequestBody User user){
		List<User> list = DBUtil.generateUserList();
		List<User> filter = list.stream().filter(u->u.getUsername().equals(user.getUsername())
				&& u.getPassword().equals(user.getPassword())).collect(Collectors.toList());
		return filter==null?null:filter.get(0);
	}
	
	@PostMapping("/users/register")
	public void registerUser(@RequestBody User user){
		System.out.println(user.toString());
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id){
		System.out.println("User deleted with id : "+id);
	}
}
