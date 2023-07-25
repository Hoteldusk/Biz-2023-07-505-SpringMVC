package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookDto;

public interface RentDao {
	public void create_rent_book_table();
	
	@Select("select * from tbl_rent_book")
	public List<RentBookDto> selectAll();
	public RentBookDto findById(long id);
	
	public List<RentBookDto> findByBCode(String bcode);
	public List<RentBookDto> findByMCode(String mcode);
	
	public int insert (RentBookDto rentBookDto);
	public int update (RentBookDto rentBookDto);
}
