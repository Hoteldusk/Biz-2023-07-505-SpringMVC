package com.callor.bus.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.callor.bus.dto.TerDto;

public class DeduplicationUtils {
    public static List<TerDto> removeDuplicates(List<TerDto> list) {
        Set<TerDto> set = new HashSet<>();
        List<TerDto> deduplicatedList = new ArrayList<>();

        for (TerDto dto : list) {
            if (set.add(dto)) {
                deduplicatedList.add(dto);
            }
        }

        return deduplicatedList;
    }
}