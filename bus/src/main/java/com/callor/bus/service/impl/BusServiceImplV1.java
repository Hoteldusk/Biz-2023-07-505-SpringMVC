package com.callor.bus.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.bus.dao.BusDao;
import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;
import com.callor.bus.service.BusService;

@Repository
public class BusServiceImplV1 implements BusService {

	protected final BusDao busDao;

	public BusServiceImplV1(BusDao busDao) {
		super();
		this.busDao = busDao;
	}

	@Override
	public List<UserDto> selectAll() {
		return busDao.selectAll();
	}

	@Override
	public UserDto findById(String id) {
		UserDto dto = busDao.findById(id);
		return dto;
	}

	@Override
	public int insert(UserDto dto) {
		// TODO Auto-generated method stub
		return busDao.insert(dto);
	}

	@Override
	public String userLogin(UserDto userDto) {
		
		String id = userDto.getBu_id();
		String pwd = userDto.getBu_password();
		String msg = "";
			 
		UserDto dto = busDao.findById(id);
		if(dto == null) {
			msg = "ID를 확인해주세요.";
			return msg;
		} else if (dto.getBu_id().equals(id) && dto.getBu_password().equals(pwd)) {
			return "OK";
		} else {
			msg = "password를 확인해주세요.";
			return msg;
		}

	}

	@Override
	public List<UsuallyDto> usuallyList(String id) {
		// TODO Auto-generated method stub
		return busDao.usuallyTerminal(id);
	}

	@Override
	public int update(UserDto userDto) {
		// TODO Auto-generated method stub
		return busDao.update(userDto);
	}

	@Override
	public int delete(String id) {
		
		// TODO Auto-generated method stub
		return busDao.delete(id);
	}

	@Override
	public UserDto findId(String bu_name, String bu_tel) {
		// TODO Auto-generated method stub
		return busDao.findId(bu_name, bu_tel);
	}

	@Override
	public UserDto findPw(String bu_id, String bu_tel) {
		// TODO Auto-generated method stub
		return busDao.findPw(bu_id, bu_tel);
	}

}
