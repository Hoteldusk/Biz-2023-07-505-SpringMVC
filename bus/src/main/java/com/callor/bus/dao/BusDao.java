package com.callor.bus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;

public interface BusDao {
	
	@Select("select * from tbl_bus_user")
	public List<UserDto> selectAll();
	
	public int insert(UserDto dto);
	
	@Select("select * from tbl_bus_user where bu_id = #{id}")
	public UserDto findById(String id);
	
	@Select("select US.s_terminal, US.e_terminal, U.bu_name from tbl_usually US "
			+ "left join tbl_bus_user U "
			+ "	on US.us_buid = #{id} "
			+ "where U.bu_id = #{id}")
	public List<UsuallyDto> usuallyTerminal(String id); 

}
