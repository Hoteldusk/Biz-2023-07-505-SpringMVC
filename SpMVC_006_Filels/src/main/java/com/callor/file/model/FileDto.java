package com.callor.file.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FileDto {
	private long f_seq; 			//bigint 			primary key 	auto_increment,
	private long f_bseq; 		//	bigint,
	private String f_image; 		//varchar(255),
	private String f_origin_image; //	varchar(255)
}
