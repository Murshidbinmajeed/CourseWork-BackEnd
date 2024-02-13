package com.example.springboot.service;

import com.example.springboot.entity.entityVO.AuthenticationRequest;
import com.example.springboot.entity.entityVO.AuthenticationResponse;
import com.example.springboot.entity.entityVO.RegisterRequest;

public interface AuthenticationService {

	public AuthenticationResponse register(RegisterRequest request);

	public AuthenticationResponse authenticate(AuthenticationRequest request);

}
