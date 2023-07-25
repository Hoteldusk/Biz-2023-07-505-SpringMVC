package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.dao.RentDao;
import com.callor.rent.models.RentBookDto;
import com.callor.rent.service.RentBookService;

@Service
public class RentBookServiceImplV1 implements RentBookService{

	protected final RentDao rentDao;
	
	
	@Autowired
	public RentBookServiceImplV1(RentDao rentDao) {
		this.rentDao = rentDao;
	}



	@Override
	public List<RentBookDto> selectAll() {
		List<RentBookDto> rentList = rentDao.selectAll(); 
		return rentList;
	}

}
