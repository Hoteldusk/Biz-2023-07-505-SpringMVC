package com.callor.bus.dao;

import java.util.List;

import com.callor.bus.dto.TerDriveDto;

public interface TerDriveDao {

	public void insert(TerDriveDto terDriveDto);

	public void deleteAll();

	public List<TerDriveDto> selectAll();

	public List<TerDriveDto> getTerDriveByTl_Id(String terLinkId);
}
