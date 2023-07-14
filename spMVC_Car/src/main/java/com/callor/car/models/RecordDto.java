package com.callor.car.models;

public class RecordDto {
	private String c_sequence;	//BIGINT	PRIMARY KEY	AUTO_INCREMENT,
    private String c_divison;	//VARCHAR(6),
    private String c_location; 	//VARCHAR(20),
    private String c_depDate;	//VARCHAR(20),
    private String c_depTime;	//VARCHAR(20),
    private String c_arrDate;	//VARCHAR(20),
    private String c_arrTime;	//VARCHAR(20),
    private String c_depDist;	//VARCHAR(20),
    private String c_arrDist;	//VARCHAR(20),
    private int c_cost;		//INT
	public RecordDto() {
		
	}
	public RecordDto(String c_sequence, String c_divison, String c_location, String c_depDate, String c_depTime,
			String c_arrDate, String c_arrTime, String c_depDist, String c_arrDist, int c_cost) {
		super();
		this.c_sequence = c_sequence;
		this.c_divison = c_divison;
		this.c_location = c_location;
		this.c_depDate = c_depDate;
		this.c_depTime = c_depTime;
		this.c_arrDate = c_arrDate;
		this.c_arrTime = c_arrTime;
		this.c_depDist = c_depDist;
		this.c_arrDist = c_arrDist;
		this.c_cost = c_cost;
	}
	public String getC_sequence() {
		return c_sequence;
	}
	public void setC_sequence(String c_sequence) {
		this.c_sequence = c_sequence;
	}
	public String getC_divison() {
		return c_divison;
	}
	public void setC_divison(String c_divison) {
		this.c_divison = c_divison;
	}
	public String getC_location() {
		return c_location;
	}
	public void setC_location(String c_location) {
		this.c_location = c_location;
	}
	public String getC_depDate() {
		return c_depDate;
	}
	public void setC_depDate(String c_depDate) {
		this.c_depDate = c_depDate;
	}
	public String getC_depTime() {
		return c_depTime;
	}
	public void setC_depTime(String c_depTime) {
		this.c_depTime = c_depTime;
	}
	public String getC_arrDate() {
		return c_arrDate;
	}
	public void setC_arrDate(String c_arrDate) {
		this.c_arrDate = c_arrDate;
	}
	public String getC_arrTime() {
		return c_arrTime;
	}
	public void setC_arrTime(String c_arrTime) {
		this.c_arrTime = c_arrTime;
	}
	public String getC_depDist() {
		return c_depDist;
	}
	public void setC_depDist(String c_depDist) {
		this.c_depDist = c_depDist;
	}
	public String getC_arrDist() {
		return c_arrDist;
	}
	public void setC_arrDist(String c_arrDist) {
		this.c_arrDist = c_arrDist;
	}
	public int getC_cost() {
		return c_cost;
	}
	public void setC_cost(int c_cost) {
		this.c_cost = c_cost;
	}
	@Override
	public String toString() {
		return "RecordDto [c_sequence=" + c_sequence + ", c_divison=" + c_divison + ", c_location=" + c_location
				+ ", c_depDate=" + c_depDate + ", c_depTime=" + c_depTime + ", c_arrDate=" + c_arrDate + ", c_arrTime="
				+ c_arrTime + ", c_depDist=" + c_depDist + ", c_arrDist=" + c_arrDist + ", c_cost=" + c_cost + "]";
	}
    
    
}
