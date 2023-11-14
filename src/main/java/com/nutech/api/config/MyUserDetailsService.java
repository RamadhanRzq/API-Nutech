package com.nutech.api.config;

import com.nutech.api.model.MyUserDetails;
import com.nutech.api.model.User;
import com.nutech.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
	@Autowired private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Mengambil data user
		User user = this.userRepo.findByEmail(username);
		if (user==null) {
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
			return new MyUserDetails(user);
	}

}
