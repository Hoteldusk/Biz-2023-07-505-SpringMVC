package com.callor.bus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.bus.dao.TerDao;
import com.callor.bus.dao.TerDriveDao;
import com.callor.bus.dao.TerLinkDao;
import com.callor.bus.dao.TerScheduleDao;
import com.callor.bus.dto.TerDriveDto;
import com.callor.bus.dto.TerDto;
import com.callor.bus.dto.TerLinkDto;
import com.callor.bus.dto.TerScheduleDto;
import com.callor.bus.dto.TerScheduleVO;
import com.callor.bus.utils.DeduplicationUtils;

@Service
public class LoadDB {
	private final TerDao terDao;
	private final TerLinkDao terLinkDao;
	private final TerDriveDao terDriveDao;
	private final TerScheduleDao terScheduleDao;
	
	@Autowired
	public LoadDB(TerDao terDao, TerLinkDao terLinkDao, TerDriveDao terDriveDao, TerScheduleDao terScheduleDao) {
		super();
		this.terDao = terDao;
		this.terLinkDao = terLinkDao;
		this.terDriveDao = terDriveDao;
		this.terScheduleDao = terScheduleDao;
	}
	
	public List<TerDto> loadDepTerData() {
        List<TerLinkDto> terLinkDtos = terLinkDao.selectAll();
        List<TerDto> depTerDtos = new ArrayList<>();
        for (TerLinkDto terLinkDto: terLinkDtos) {
            // 출발정류장 반환
            TerDto depTerDto = terDao.getTerById(terLinkDto.getTl_DepTerId());
            depTerDtos.add(depTerDto);
        }
        return DeduplicationUtils.removeDuplicates(depTerDtos);
    }

    // 출발지 선택시 도착지 리스트 데이터 전송
    public List<TerDto> loadArrTerData(String depTerId) {
        TerDto depTerDto = terDao.getTerById(depTerId);
        List<TerDto> terDtoList = new ArrayList<>();
        List<TerLinkDto> terLinkDtoList = terLinkDao.getTerLinkByDepTerId(depTerDto.getTerId());
        for (TerLinkDto terLinkDto : terLinkDtoList) {
            TerDto terDto = terDao.getTerById(terLinkDto.getTl_ArrTerId());
            terDtoList.add(terDto);
        }
        return terDtoList;
    }

    // 출발지 도착지 드롭다운에서 선택후 시간표 게시판에 데이터 전달
    public List<TerScheduleVO> loadTerDriveAndSchedule(String depTerId, String arrTerId) {
        TerLinkDto terLinkDto = terLinkDao.getTerLinkByDepTerIdAndArrTerId(depTerId, arrTerId);
        List<TerDriveDto> terDriveDtoList = terDriveDao.getTerDriveByTl_Id(terLinkDto.getTl_Id());
        List<TerScheduleVO> terScheduleVOList = new ArrayList<>();
        // get by 2id
        // linkter id 로 db 접근 => list로 받음
        // 반환
        for (TerDriveDto terDriveDto : terDriveDtoList) {
            List<TerScheduleDto> terScheduleDtoList = terScheduleDao.getTerScheduleByTd_Id(terDriveDto.getTd_ID());
            TerScheduleVO terScheduleVO = new TerScheduleVO();

            terScheduleVO.setTd_ID(terDriveDto.getTd_ID());
            terScheduleVO.setTd_TlID(terDriveDto.getTd_TlID());
            terScheduleVO.setTd_WasteTime(terDriveDto.getTd_WasteTime());
            terScheduleVO.setTd_Fare(terDriveDto.getTd_Fare());
            terScheduleVO.setTd_Interval(terDriveDto.getTd_Interval());
            terScheduleVO.setTd_schedule(terScheduleDtoList);

            terScheduleVOList.add(terScheduleVO);
        }
        return terScheduleVOList;
    }
}
