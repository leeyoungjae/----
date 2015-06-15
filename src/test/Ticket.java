package test;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
	
	public String d_station ;
	public String a_station;
	public String year;
	public String month;
	public String day;
	public String time;
	public String person;   // 출발역 도착역 년 월 일 시간 인원
	public String user_id;
	//public ArrayList seat;
	
	public Ticket(String user_id, String d_station,String a_station,String year,String month, String day,String time,String person){
		this.user_id = user_id;
		this.d_station = d_station;
		this.a_station = a_station;
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = time;
		this.person = person;
		//this.seat = seat;
		
	}
	
	public String getD_station(){
		return d_station;
	}
	public String getA_station(){
		return a_station;
	}
	public String getYear(){
		return year;
	}
	public String getMonth(){
		return month;
	}
	public String getDay(){
		return day;
	}
	public String getTime(){
		return time;
	}
	public String getPerson(){
		return person;
	}
	public String getUserId(){
		return user_id;
	}
	
	public void setD_station(String d_station){
		this.d_station = d_station;
	}
	public void setA_station(String a_station){
		this.a_station = a_station;
	}
	public void setYear(String Year){
		this.year = year;
	}
	public void setMonth(String monty){
		this.month = month;
	}
	public void setDay(String day){
		this.day = day;
	}
	public void setTime(String time){
		this.time = time;
	}
	public void setPerson(String person){
		this.person = person;
	}
	
	public String toString(){
		return getD_station() + "--" + getA_station() + "--" + getYear() + "--" + getMonth() + "--" + getDay() + "--" + getTime() + "--" + getPerson();
	}
	
}
