package com.hj.fmrtebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hj.fmrtebackend.model.Users;
import com.hj.fmrtebackend.repository.UserRepository;

@Service
public class CustomUserDetailsService
        implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }
    
    public PasswordEncoder passwordEncoder() {
    	return this.passwordEncoder;
    }
}
