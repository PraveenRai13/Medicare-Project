package com.simplilearn.medicare.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medicare.entities.Role;
import com.simplilearn.medicare.entities.User;
import com.simplilearn.medicare.entities.UserRole;
import com.simplilearn.medicare.exceptions.UserFoundException;
import com.simplilearn.medicare.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		//encoding password with B-crypt password encoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole>roles=new HashSet <>();
		Role role=new Role();
		role.setRoleId(45);
		role.setRoleName("NORMAL");
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
		
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
@DeleteMapping("/{userId}")
public void deleteUser(@PathVariable("userId") Integer userId) {
	this.userService.deleteUser(userId);
}
@PutMapping("/{id}")
public User updateUser(@RequestBody User u,@PathVariable int id) {
	return this.userService.updateUser(u, id);
}
@ExceptionHandler(UserFoundException.class)
public ResponseEntity<?> exceptionHandler(UserFoundException ex){
	return ResponseEntity.ok(ex.getMessage());
}
}
