package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;

public interface RentBookService {

	public List<RentBookVO> selectAll();

	public int insert(RentBookVO rentBookVO);

}
