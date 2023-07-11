package com.callor.bbbs.models;

public class BbsDto {
	private long b_seq; // bigint
	private long b_pseq; /// bigint
	private String b_date; // varchar(10)
	private String b_time; // varchar(10)
	private String b_username; // varchar(125)
	// tbl_user table 에서 가져온 데이터
	private String nickname;
	private String b_subject; // varchar(125)
	private String b_content; // text
	private String b_count; // int
	private int b_update; // datetime

	public long getB_seq() {
		return b_seq;
	}

	public void setB_seq(long b_seq) {
		this.b_seq = b_seq;
	}

	public long getB_pseq() {
		return b_pseq;
	}

	public void setB_pseq(long b_pseq) {
		this.b_pseq = b_pseq;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public String getB_time() {
		return b_time;
	}

	public void setB_time(String b_time) {
		this.b_time = b_time;
	}

	public String getB_username() {
		return b_username;
	}

	public void setB_username(String b_username) {
		this.b_username = b_username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getB_subject() {
		return b_subject;
	}

	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_count() {
		return b_count;
	}

	public void setB_count(String b_count) {
		this.b_count = b_count;
	}

	public int getB_update() {
		return b_update;
	}

	public void setB_update(int b_update) {
		this.b_update = b_update;
	}

	@Override
	public String toString() {
		return "BbsDto [b_seq=" + b_seq + ", b_pseq=" + b_pseq + ", b_date=" + b_date + ", b_time=" + b_time
				+ ", b_username=" + b_username + ", b_subject=" + b_subject + ", b_content=" + b_content + ", b_count="
				+ b_count + ", b_update=" + b_update + "]";
	}

}
