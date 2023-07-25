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
public class RentBooksDto {
	private long rent_seq;	//BIGINT	not null	primary key,
	private String rent_date;	//VARCHAR(30)	not null	,
	private String rent_return_date;	//VARCHAR(10)	not null	,
	private String rent_bcode;	//VARCHAR(6)	not null	,
	private String rent_ucode;	//VARCHAR(6)	not null	,
	private String rent_return_yn;	//VARCHAR(1)		,
	private int rent_point;	//INT		
}
