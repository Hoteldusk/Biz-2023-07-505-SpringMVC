package com.callor.bus.dao;

import java.util.List;


import com.callor.bus.dto.TerDriveVO;

public interface TerDriveVODao {
	public List<TerDriveVO> getTerDriveBytdId(String td_TlId);
}
