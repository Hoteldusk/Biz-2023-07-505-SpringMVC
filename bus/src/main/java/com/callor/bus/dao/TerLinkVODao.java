package com.callor.bus.dao;

import java.util.List;

import com.callor.bus.dto.TerLinkVO;

public interface TerLinkVODao {
	
	public List<TerLinkVO> selectAll();
	public List<TerLinkVO> getTerLinkVOByDepTerId(String depTerId);
}
