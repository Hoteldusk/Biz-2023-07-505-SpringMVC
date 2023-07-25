package com.callor.book.service;

import java.util.List;

import com.callor.book.models.UsersDto;

public interface UsersService {
	public int saveUsers(UsersDto usersDto);
	public List<UsersDto> findAllUsers();
	public UsersDto findUserById(String id);
	public void updateUsers(UsersDto usersDto);
}
