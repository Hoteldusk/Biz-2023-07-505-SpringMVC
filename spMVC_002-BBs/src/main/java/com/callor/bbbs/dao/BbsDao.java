package com.callor.bbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.bbbs.models.BbsDto;

public interface BbsDao {

	@Select(" SELECT * FROM tbl_bbs ORDER BY b_date DESC, b_time DESC ")
	public List<BbsDto> selectAll();
	
	public List<BbsDto> findUserSelectLimit();
	
	public BbsDto findBySeq(long seq);
}
