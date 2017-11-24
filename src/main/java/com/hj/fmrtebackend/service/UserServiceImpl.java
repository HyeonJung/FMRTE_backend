package com.hj.fmrtebackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hj.fmrtebackend.model.Authority;
import com.hj.fmrtebackend.model.AuthorityRole;
import com.hj.fmrtebackend.model.Role;
import com.hj.fmrtebackend.model.Users;
import com.hj.fmrtebackend.repository.AuthorityRepository;
import com.hj.fmrtebackend.repository.UserRepository;
import com.hj.fmrtebackend.support.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authrityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public Users saveUser(UserDto userDto) {
		
		Users user = new Users();
		user.setName(userDto.getName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		
		user = userRepository.save(user);
		
		List<Authority> authorities = new ArrayList<Authority>();
        AuthorityRole authorityRole = new AuthorityRole(user.getId(), Role.ROLE_USER);
        Authority authority = new Authority();
        authority.setAuthorityRole(authorityRole);
        
        authorities.add(authority);
        
        authrityRepository.save(authorities);
        
		return user;
	}
	
}
