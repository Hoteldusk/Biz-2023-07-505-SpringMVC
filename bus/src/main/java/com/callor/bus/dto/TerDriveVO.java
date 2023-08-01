package com.callor.bus.dto;


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
public class TerDriveVO {
	private String td_Id;//,varchar(20)
	private String td_TlId;//,varchar(20)
	private String td_interval;//,varchar(6)
	private String td_wasteTime;//,varchar(6)
	private int td_fare;//,int
	private String tes_schedule;//,varchar(6)
	private boolean isCloset = false;
}
