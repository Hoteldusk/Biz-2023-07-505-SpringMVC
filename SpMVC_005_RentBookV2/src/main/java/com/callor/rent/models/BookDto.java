package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * STS  Ctrl + Shift + y : 모두 소문자로 만들기
 * 		Ctrl + shift + x : 모두 대문자로 만들기
 * 		Ctrl + d : 현재 커서 라인 삭제
 * 		Ctrl + z : Undo, 명령 취소하기
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
	
	private String b_code; //	varchar(6)
	private String b_name; //	varchar(125)
	private String b_auther; //	varchar(125)
	private String b_comp; //	varchar(125)
	private int b_year; //	int
	private int b_iprice; //	int
	private int b_rprice; //	int
	private String b_use; //	varchar(1)


}
