package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.rent.models.MemberDto;

public interface MemberDao {

	public int insert(MemberDto memberDto);

	@Select("select MAX(m_code) from tbl_members")
	public String getMaxCode();

	@Select("select * from tbl_members order by m_name")
	public List<MemberDto> selectAll();

	@Select("select * from tbl_members where m_code = #{id}")
	public MemberDto findById(String id);
	
	@Select("select * from tbl_members where m_name like concat('%', #{name}, '%' order by m_name")
	public List<MemberDto> findByName(String name);
	
	@Select("select * from tbl_members where m_tel like concat('%', #{tel}, '%' order by m_tel")
	public List<MemberDto> findByTel(String tel);
	
	public void create_member_table(String dumy);

	@Select("select * from tbl_members where m_name = #{name} AND m_tel = #{tel}")
	public MemberDto findNameAndTel(@Param("name") String name, @Param("tel") String tel);

	@Update("update tbl_members set m_name = #{m_name}, m_tel = #{m_tel}, m_addr = #{m_addr} where m_code = #{m_code}")
	public int update(MemberDto memberDto);
}
