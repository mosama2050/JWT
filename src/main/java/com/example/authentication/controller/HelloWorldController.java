package com.example.authentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

    @RequestMapping({"/hello"})
    public String hello() {
		// Get the current authentication
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// Check if the user is authenticated
		if (authentication != null && authentication.isAuthenticated()) {
			// Get the UserDetails object from the authentication
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			// Get the username
			String username = userDetails.getUsername();

			// Get the roles
			// Assuming your UserDetails implementation provides getAuthorities() for roles
			String roles = userDetails.getAuthorities().toString();

			// Use the username and roles as needed
			return "Hello, " + username + "! Your roles are: " + roles;
		} else {
			return "Hello World";
		}
	}
}
