package com.callor.car.dao;

import java.util.List;

import com.callor.car.models.RecordDto;

public interface RecordDao {
	public void insert(RecordDto recordDto);
	public void update(RecordDto recordDto);
	public List<RecordDto> selectAll();
}
