package com.callor.bus.dao;

import java.util.List;

import com.callor.bus.dto.TerDto;

public interface TerDao {
	
	public void insert(TerDto terDto);

	public void deleteAll();

	public List<TerDto> selectAll();

	public TerDto getTerById(String terId);

	public List<TerDto> getTerByRegion(String terRegion);
}
