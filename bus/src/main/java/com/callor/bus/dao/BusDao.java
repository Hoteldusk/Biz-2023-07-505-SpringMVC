package com.callor.bus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;

public interface BusDao {
	
	@Select("select * from tbl_bus_user")
	public List<UserDto> selectAll();
	
	public int insert(UserDto dto);
	
	@Select("select * from tbl_bus_user where bu_id = #{id}")
	public UserDto findById(String id);
	
	@Select("select US.s_terminal, US.e_terminal, US.us_stcode, US.us_etcode from tbl_usually US "
			+ "left join tbl_bus_user U "
			+ "	on US.us_buid = U.bu_id "
			+ "where U.bu_id = #{id}")
	public List<UsuallyDto> usuallyTerminal(String id);

	public int update(UserDto userDto);

	@Delete("delete from tbl_bus_user where bu_id = #{id}")
	public int delete(String id); 

	@Insert("insert into tbl_usually(s_terminal, e_terminal, us_stcode, us_etcode, us_buid) "
	        + "VALUES (#{s_terminal}, #{e_terminal}, #{us_stcode}, #{us_etcode}, #{us_buid})")
	public int usuallyinsert(UsuallyDto usuallyDto);
	
	@Select("SELECT * FROM tbl_bus_user "
			+ " WHERE bu_name = #{bu_name} AND bu_tel = #{bu_tel}")
	public UserDto findId(@Param("bu_name") String bu_name, @Param("bu_tel") String bu_tel);

	@Select("SELECT * FROM tbl_bus_user"
			+ " WHERE bu_id = #{bu_id} AND bu_tel = #{bu_tel}")
	public UserDto findPw(@Param("bu_id") String bu_id, @Param("bu_tel") String bu_tel); 
}