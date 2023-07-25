package com.callor.book.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
	private String u_code;
	private String u_name;	
	private String u_tel;	
	private String u_addr;	
}
