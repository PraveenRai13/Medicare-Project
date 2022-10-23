package com.simplilearn.medicare.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medicare.configurations.JwtUtil;
import com.simplilearn.medicare.entities.JWTRequest;
import com.simplilearn.medicare.entities.JWTResponse;
import com.simplilearn.medicare.entities.User;
import com.simplilearn.medicare.exceptions.UserNotFoundException;
import com.simplilearn.medicare.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception
	{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
		}catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		UserDetails userdetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userdetails);
		return ResponseEntity.ok(new JWTResponse(token));
		
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("User Disable");
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credential" + e.getMessage());
		}
		
		}
	// to get online user details
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
	}
}
