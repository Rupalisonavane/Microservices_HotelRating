package org.coderRups.UserService.controller;

import java.util.ArrayList;
import java.util.List;

import org.coderRups.UserService.entity.User;
import org.coderRups.UserService.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<?> getUser(){
		List<User> users=userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId)
	{
		User user=userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user ){
		
		    User users=    userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(users) ;
	}
}
