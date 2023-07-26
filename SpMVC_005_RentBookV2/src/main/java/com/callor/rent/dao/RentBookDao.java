package com.callor.rent.dao;

import java.util.List;

import com.callor.rent.models.RentBookVO;

public interface RentBookDao {
	
	public List<RentBookVO> selectAll();
	
	public RentBookVO findById(long id);
	
	public List<RentBookVO> findByBCode(String bcode);
	public List<RentBookVO> findByMCode(String mcode);
	
	public int insert(RentBookVO retnBookVO);
	public int update(RentBookVO retnBookVO);
	
	public void create_rentbook_table(String dumy);

}
