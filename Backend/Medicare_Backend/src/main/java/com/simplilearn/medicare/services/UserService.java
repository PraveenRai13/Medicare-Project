package com.simplilearn.medicare.services;

import java.util.Set;

import com.simplilearn.medicare.entities.User;
import com.simplilearn.medicare.entities.UserRole;

public interface UserService {
//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	// get user by user name;
	public User getUser(String userName);
	public void deleteUser(Integer userId);
	public User updateUser(User u,int id);
}
