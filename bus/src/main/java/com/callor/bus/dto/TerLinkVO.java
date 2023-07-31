package com.callor.bus.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TerLinkVO {
	private String tl_Id;//,varchar(20)
	private String tl_depTerId;//,varchar(10)
	private String tl_arrTerId;//,varchar(10)
	private String depTerName;//,varchar(30)
	private String arrTerName;//,varchar(30)
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerLinkVO dto = (TerLinkVO) o;
        return Objects.equals(tl_depTerId, dto.tl_depTerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tl_depTerId);
    }
}
