package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest/auth")
public class ApplicationController {

	@GetMapping("/process")
	public String process() {

		return "processing...";
	}
}
