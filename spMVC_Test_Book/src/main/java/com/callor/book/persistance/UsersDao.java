package com.callor.book.persistance;

import java.util.List;

import com.callor.book.models.UsersDto;

public interface UsersDao {
	public int insert(UsersDto usersDto);
	public List<UsersDto> selectAll();
	public UsersDto findById(String id);
	public void update(UsersDto usersDto);
	public UsersDto findbyName(String name);
}
