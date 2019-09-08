package com.springsecuritydb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritydb.model.CustomUserDetails;
import com.springsecuritydb.model.Users;
import com.springsecuritydb.repo.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<Users> optionalUsers = usersRepository.findByName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		CustomUserDetails customUserDetails = optionalUsers.map(CustomUserDetails::new).get();
		return customUserDetails;
	}

}
