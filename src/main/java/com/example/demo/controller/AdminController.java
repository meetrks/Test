package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String adduserByAdmin(@RequestBody User user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		UserRepository.save(user);
		return "user added successfully...";
	}

}
