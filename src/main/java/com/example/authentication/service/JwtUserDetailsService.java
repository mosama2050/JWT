package com.example.authentication.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.authentication.model.MyUserDetails;

import com.example.authentication.model.Users;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class 	JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		return user.map(MyUserDetails::new).get();

	}

	public Users save(Users user) {

		user.setUsername(user.getUsername());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

}