package com.simplilearn.medicare;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.simplilearn.medicare.entities.Role;
import com.simplilearn.medicare.entities.User;
import com.simplilearn.medicare.entities.UserRole;
import com.simplilearn.medicare.exceptions.UserFoundException;
import com.simplilearn.medicare.services.UserService;

@SpringBootApplication
public class MedicareBackendApplication implements CommandLineRunner {
@Autowired
private UserService userService;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(MedicareBackendApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		try {
		// TODO Auto-generated method stub
	User user = new User();
	user.setFirstName("Praveen");
	user.setLastName("Rai");
	user.setEmail("praveen@gmail.com");
	user.setUsername("praveen03");
	user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
	user.setMobileNo("8655003532");
	Role role1 = new Role();
	role1.setRoleId(44);
	role1.setRoleName("ADMIN");
	Set<UserRole> userRoleSet =new HashSet<>();
	UserRole userRole = new UserRole();
	userRole.setRole(role1);
	userRole.setUser(user);
	userRoleSet.add(userRole);
	User user1 =this.userService.createUser(user, userRoleSet);
	System.out.println(user1.getUsername());
		
		}catch(UserFoundException e) {
			e.printStackTrace();
		}
		}
	
		
	}

