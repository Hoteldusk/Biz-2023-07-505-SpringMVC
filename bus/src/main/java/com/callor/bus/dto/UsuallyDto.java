package com.callor.bus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuallyDto {
	
	private String s_terminal;
	private String e_terminal;
	private String us_buid;
	private String us_stcode;
	private String us_etcode;

}