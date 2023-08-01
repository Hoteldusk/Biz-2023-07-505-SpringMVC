package com.callor.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;

@Service
public interface BusService {
	
	public List<UserDto> selectAll();
	public UserDto findById(String id);
	public int insert(UserDto dto);

	public String userLogin(UserDto userDto);
	
	public List<UsuallyDto> usuallyList(String id);
	public int update(UserDto userDto);
	public int delete(String id);
	
	public UserDto findId(String bu_name, String bu_tel);
	public UserDto findPw(String bu_id, String bu_tel);
}
