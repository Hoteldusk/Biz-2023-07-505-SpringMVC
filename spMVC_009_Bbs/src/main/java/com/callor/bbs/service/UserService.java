package com.callor.bbs.service;

import com.callor.bbs.models.UserDto;

public interface UserService {
	
	// 회원가입을 실행하는 method
	public UserDto join(UserDto userDto);
	
	public UserDto findById(String username);
}
