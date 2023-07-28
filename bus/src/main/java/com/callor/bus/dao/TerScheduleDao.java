package com.callor.bus.dao;

import java.util.List;

import com.callor.bus.dto.TerScheduleDto;

public interface TerScheduleDao {

	public void insert(TerScheduleDto terScheduleDto);

	public void deleteAll();

	public List<TerScheduleDto> getTerScheduleByTd_Id(String terDriveId);
}
