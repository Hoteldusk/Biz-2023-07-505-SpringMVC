package com.callor.bus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.bus.dto.TerLinkDto;

public interface TerLinkDao {
	
	public void insert(TerLinkDto terLinkDto);
	
    public void deleteAll();
    
    public List<TerLinkDto> selectAll();
    
    public List<TerLinkDto> getTerLinkByDepTerId(String depTerId);
    
    public TerLinkDto getTerLinkByDepTerIdAndArrTerId(@Param("depTerId")String depTerId, @Param("arrTerId")String arrTerId);
}
