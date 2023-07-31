package com.callor.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.bus.dao.TerDriveVODao;
import com.callor.bus.dao.TerLinkDao;
import com.callor.bus.dao.TerLinkVODao;
import com.callor.bus.dto.TerDriveVO;
import com.callor.bus.dto.TerLinkDto;
import com.callor.bus.dto.TerLinkVO;
import com.callor.bus.utils.DeduplicationUtils;

@Service
public class LoadDB {

	private final TerLinkVODao terLinkVODao;
	private final TerDriveVODao terDriveVODao;
	private final TerLinkDao terLinkDao;

	@Autowired
	public LoadDB(TerLinkVODao terLinkVODao, TerDriveVODao terDriveVODao, TerLinkDao terLinkDao) {
		this.terLinkVODao = terLinkVODao;
		this.terDriveVODao = terDriveVODao;
		this.terLinkDao = terLinkDao;
	}

	public List<TerLinkVO> loadDepTerData() {
        List<TerLinkVO> terLinkVOs = terLinkVODao.selectAll();
        
        return DeduplicationUtils.removeDuplicates(terLinkVOs);
    }

    // 출발지 선택시 도착지 리스트 데이터 전송
    public List<TerLinkVO> loadArrTerData(String depTerId) {
    	
    	List<TerLinkVO> terDriveVOList = terLinkVODao.getTerLinkVOByDepTerId(depTerId);
    	
        return terDriveVOList;
    }

    // 출발지 도착지 드롭다운에서 선택후 시간표 게시판에 데이터 전달
    public List<TerDriveVO> loadTerDriveAndSchedule(String depTerId, String arrTerId) {
        TerLinkDto terLinkDto = terLinkDao.getTerLinkByDepTerIdAndArrTerId(depTerId, arrTerId);
        List<TerDriveVO> terDriveVOList = terDriveVODao.getTerDriveBytdId(terLinkDto.getTl_Id());
        return terDriveVOList;
    }
}
