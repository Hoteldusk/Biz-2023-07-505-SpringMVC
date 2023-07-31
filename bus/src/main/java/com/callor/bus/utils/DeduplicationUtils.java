package com.callor.bus.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.callor.bus.dto.TerDto;
import com.callor.bus.dto.TerLinkVO;

public class DeduplicationUtils {
	
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
    
}