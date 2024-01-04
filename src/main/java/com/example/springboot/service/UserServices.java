package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springboot.repository.UserRepository;
import com.example.springboot.security.SecurityUser;

@Service
public class UserServices implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username >>>>>>>>>>"+username);
		var u = userRepository.findUserByUserName(username);
		System.out.println("this output for u >>>>>>>>."+u);
		
		return u.map(user -> new SecurityUser())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"+username));
	}



}
