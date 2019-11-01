package com.unifiedDashboard.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifiedDashboard.model.User;
import com.unifiedDashboard.repository.UserRepository;
import com.unifiedDashboard.utilities.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		List<User> users=userRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user){
		String email=user.getEmail().toString().trim();
		List<User> userResult=userRepository.findByEmail(email);
		if(userResult.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body("User Already exist");
		}
		else {
			
			String pwd=EncryptUtil.encryptUsingMd5(user.getPassword().trim().toString());			
			user.setPassword(pwd);
			@Valid User result=userRepository.save(user);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
			
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody User user){
		String email=user.getEmail().trim().toString();
		String password=EncryptUtil.encryptUsingMd5(user.getPassword().trim().toString());
		List<User> resultUsers=userRepository.findByEmail(email);
		if(resultUsers.size()<1) {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid Email ID");
		}
		else {
			System.out.println(resultUsers.get(0).getPassword());
			System.out.println(password);
			if(resultUsers.get(0).getPassword().equals(password)) {
				return ResponseEntity.status(HttpStatus.OK).body(resultUsers);
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("Incorrect Password");
			}
		}
		
		
	}
	
	
	
	
	

}
