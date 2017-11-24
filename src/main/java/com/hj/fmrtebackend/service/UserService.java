package com.hj.fmrtebackend.service;

import com.hj.fmrtebackend.model.Users;
import com.hj.fmrtebackend.support.UserDto;

public interface UserService {

	/**
	 * 회원 정보 저장
	 * @param userDto
	 * @return
	 */
	Users saveUser(UserDto userDto);
}
