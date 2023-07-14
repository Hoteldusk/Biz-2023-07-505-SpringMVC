package com.callor.car.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.dao.RecordDao;
import com.callor.car.models.RecordDto;

/*
 * @RequestParam("c_divison") String division,
            @RequestParam("c_depDist") String departureDistance,
            @RequestParam("c_location") String location,
            @RequestParam("arrDist") String arrivalDistance,
            @RequestParam("c_cost") int cost)
 */

@Service
public class CarService {

	protected final RecordDao recordDao;
	
	@Autowired
	public CarService(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public void saveData(String division, String departureDistance, String location, String arrivalDistance, int cost) {
		
		RecordDto recordDto = new RecordDto();
		
		recordDto.setC_divison(division);
		recordDto.setC_depDist(departureDistance);
		recordDto.setC_location(location);
		recordDto.setC_arrDist(arrivalDistance);
		recordDto.setC_cost(cost);
		
		String currentDate = currentDate();
		String currentTime = currentTime();
		
		recordDto.setC_arrDate(currentDate);
		recordDto.setC_arrTime(currentTime);
		
		recordDto.setC_depDate("(미입력상태)");
		recordDto.setC_depTime("(미입력상태)");
		
		recordDao.insert(recordDto);
	}
	
	public List<RecordDto> getDatas() {
		
		List<RecordDto> recordList = recordDao.selectAll();
		
		return recordList; 
	}
	
	
	protected String currentDate() {
        // 현재 시간과 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        
        // 날짜 포맷 지정
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 날짜를 문자열로 변환
        String dateString = currentDate.format(dateFormatter);
        
        return dateString;
    }
	
	protected String currentTime() {
        // 현재 시간 가져오기
        LocalTime currentTime = LocalTime.now();
        
        // 시간 포맷 지정
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        // 시간을 문자열로 변환
        String timeString = currentTime.format(timeFormatter);
        
        return timeString;
    }
}


