package com.callor.bus.utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.callor.bus.dto.TerDriveVO;
import com.callor.bus.dto.TerLinkVO;

public class Utils {
	
    public static <T> List<T> removeDuplicates(List<T> list) {
    	Set<T> set = new HashSet<>();
        List<T> deduplicatedList = new ArrayList<>();

        for (T dto : list) {
            if (set.add(dto)) {
                deduplicatedList.add(dto);
            }
        }

        return deduplicatedList;
    }
    
    public static TerDriveVO setClosestTime(List<TerDriveVO> volist) {
    	
    	// 현재 시간을 구함
        LocalTime now = LocalTime.now();

        // 현재 시간 이후의 시간만 추출    	
    	List<TerDriveVO> filteredTimeList = new ArrayList<>();
        for (TerDriveVO dto : volist) {
            LocalTime time = LocalTime.parse(dto.getTes_schedule());
            if (time.isAfter(now)) {
                filteredTimeList.add(dto);
            }
        }
        
        if(filteredTimeList.size() < 1) {
        	return null;
        }
        
        TerDriveVO closestTime = null;
        
        long minDifference = Long.MAX_VALUE;
        
        for (TerDriveVO dto : filteredTimeList) {
            LocalTime time = LocalTime.parse(dto.getTes_schedule());
            long difference = Math.abs(now.toSecondOfDay() - time.toSecondOfDay());
            if (difference < minDifference) {
                minDifference = difference;
                closestTime = dto;
            }
        }

        // 가장 가까운 시간을 표시하기 위해 isClosest 필드를 true로 설정
        if (closestTime != null) {
            closestTime.setCloset(true);
        }

        // 결과 객체 반환
        return closestTime;
    }
}