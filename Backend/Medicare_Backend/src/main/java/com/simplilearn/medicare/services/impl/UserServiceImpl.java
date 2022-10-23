package com.simplilearn.medicare.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medicare.entities.User;
import com.simplilearn.medicare.entities.UserRole;
import com.simplilearn.medicare.exceptions.UserFoundException;
import com.simplilearn.medicare.exceptions.UserNotFoundException;
import com.simplilearn.medicare.repositories.RoleRepository;
import com.simplilearn.medicare.repositories.UserRepository;
import com.simplilearn.medicare.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User a = this.userRepository.findByUsername(user.getUsername());
		if (a != null) {
			System.out.println("user is already existed");
			throw new UserFoundException();
		} else
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
		user.getUserRoles().addAll(userRoles);
		a = this.userRepository.save(user);

		return a;
	}
//getting user by user name
	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUsername(userName);
	}
	@Override
	public void deleteUser(Integer userId) {
		this.userRepository.deleteById(userId);
		
	}
	@Override
	public User updateUser(User newdata, int id) {
		if(userRepository.findById(id).isPresent()) {
			User olddata=userRepository.findById(id).get();
			olddata.setFirstName(newdata.getFirstName());
			olddata.setLastName(newdata.getLastName());
			olddata.setEmail(newdata.getEmail());
			olddata.setMobileNo(newdata.getMobileNo());
			olddata.setPassword(newdata.getPassword());
			return userRepository.save(olddata);
		}else
		return null;
	}

}
