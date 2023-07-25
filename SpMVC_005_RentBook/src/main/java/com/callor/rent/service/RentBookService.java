package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.RentBookDto;

public interface RentBookService {

	List<RentBookDto> selectAll();
	
}
