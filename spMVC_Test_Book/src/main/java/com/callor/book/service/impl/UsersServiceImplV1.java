package com.callor.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.book.models.BooksDto;
import com.callor.book.models.UsersDto;
import com.callor.book.persistance.UsersDao;
import com.callor.book.service.UsersService;

@Service
public class UsersServiceImplV1 implements UsersService{

	protected final UsersDao usersDao;
	
	@Autowired
	public UsersServiceImplV1(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public int saveUsers(UsersDto usersDto) {
		usersDao.insert(usersDto);
		String userCode = usersDto.getU_code();
		String userName = usersDto.getU_name();
		
		UsersDto userDto = usersDao.findById(userCode);
		if(userDto != null) {
			return 1;
		}
		userDto = usersDao.findbyName(userName);
		if(userDto != null) {
			return 2;
		}
		usersDao.insert(usersDto);
		return 0;
	}

	

	@Override
	public List<UsersDto> findAllUsers() {
		List<UsersDto> usersList = usersDao.selectAll();
		return usersList;
	}

	@Override
	public UsersDto findUserById(String id) {
		UsersDto userDto = usersDao.findById(id); 
		return userDto;
	}

	@Override
	public void updateUsers(UsersDto usersDto) {
		usersDao.update(usersDto); 
	}

}
