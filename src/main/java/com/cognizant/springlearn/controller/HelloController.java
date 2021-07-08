package com.cognizant.springlearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path="/hello")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world",HttpStatus.OK);
	}
}
