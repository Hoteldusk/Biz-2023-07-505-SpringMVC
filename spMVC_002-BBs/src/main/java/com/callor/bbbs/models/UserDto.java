package com.callor.bbbs.models;

public class UserDto {
	private String username;	//varchar(125)		PRIMARY KEY
	private String nickname;	//varchar(125)		
	private String tel;			//varchar(20)		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", nickname=" + nickname + ", tel=" + tel + "]";
	}	
}
