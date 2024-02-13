package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.entityVO.AuthenticationRequest;
import com.example.springboot.entity.entityVO.AuthenticationResponse;
import com.example.springboot.entity.entityVO.RegisterRequest;
import com.example.springboot.service.AuthenticationService;

@RestController
@RequestMapping("/api/view1/auth")
public class AuthController {

	@Autowired
	private final AuthenticationService authService;

	public AuthController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
		System.out.println(request);
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
}
