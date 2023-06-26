package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{
	

	/*
	 * List<UerDto> userList 객체를 생성하고
	 * 임의로 생성한 3명의 User 정보를 add 하기
	 * User 리스트를 return 하기
	 */
	@Override
	public List<UserDto> selectAll() {
		
		List<UserDto> userList = new ArrayList<>();
		
		UserDto user1 = new UserDto();
		user1.setUsername("aaa");
		user1.setName("홍길동");
		user1.setPassword("1234");
		user1.setAge(21);
		user1.setTel("010-1111-1111");
		user1.setAddr("광주광역시");
		userList.add(user1);
		
		UserDto user2 = new UserDto();
		user2.setUsername("bbb");
		user2.setName("성춘향");
		user2.setPassword("2345");
		user2.setAge(18);
		user2.setTel("010-1111-1112");
		user2.setAddr("부산광역시");
		userList.add(user2);
		
		UserDto user3 = new UserDto();
		user3.setUsername("ccc");
		user3.setName("이몽룡");
		user3.setPassword("3456");
		user3.setAge(20);
		user3.setTel("010-1111-1113");
		user3.setAddr("서울특별시");
		userList.add(user3);
		
		// setter 를 사용하는법
		// field 생성자를 사용하는법
		// field 생성자를 사용하는 경우 원하는 변수에 값이 정확히 저장되는지 확인하기 어렵다
		
		return userList;
	}

	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int input(UserDto dto) {
		
		
		
		return 0;
	}

}
