package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.rent.dao.RentBookDao;
import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

@Service
public class RentBookServiceImplV1 implements RentBookService {

	protected final RentBookDao rentBookDao;
	public RentBookServiceImplV1(RentBookDao rentBookDao) {
		this.rentBookDao = rentBookDao;
	}

	@Override
	public List<RentBookVO> selectAll() {
		List<RentBookVO> rentList = rentBookDao.selectAll();
		return rentList;
	}

	@Override
	public int insert(RentBookVO rentBookVO) {
		// TODO Auto-generated method stub
		return rentBookDao.insert(rentBookVO);
	}

}
