package com.example.springboot.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot.config.JwtService;
import com.example.springboot.entity.Role;
import com.example.springboot.entity.Users;
import com.example.springboot.entity.entityVO.AuthenticationRequest;
import com.example.springboot.entity.entityVO.AuthenticationResponse;
import com.example.springboot.entity.entityVO.RegisterRequest;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	
	
	private final UserRepository userRespository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;

	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		var user = Users.builder()
					.userName(request.getUserName())
					.email(request.getEmail())
					.pasWord(passwordEncoder.encode(request.getPassword()))
					.role(request.getRole())
					.build();
		userRespository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = userRespository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

}
