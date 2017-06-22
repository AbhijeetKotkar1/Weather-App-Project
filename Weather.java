/*
 * 
 * @author ABHIJEET KOTKAR
 * 
 */
package com.util;

import java.util.Date;

public class Weather {
	
	String city;
	String condition;
	double maxTemperature;
	double minTemperature;
	Date date;
	
	public Weather(){}

	public Weather(String city, String condition, double maxTemperature, double minTemperature, Date date) {
		super();
		this.city = city;
		this.condition = condition;
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		
		
		//String s="-------------WEATHER--------------\t"+ "\n"+"City : \t\t\t"+city+"\n"+"Condition : \t\t"+condition+"\n"+"MaxTemperature : \t"+maxTemperature+"\n"+"MinTemperature : \t"+minTemperature+"\n"+"Date : \t\t\t"+date+"\n-----------------------------------\n\n";
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-------------WEATHER--------------\t"+ "\n");
		sb.append("City : \t\t\t"+city+"\n");
		sb.append("Condition : \t\t");
		sb.append(condition+"\n");
		sb.append("MaxTemperature : \t");
		sb.append(maxTemperature+"\n");
		sb.append("MinTemperature : \t");
		sb.append(minTemperature+"\n");
		sb.append("Date : \t\t\t"+date);
		sb.append("\n-----------------------------------\n\n");
		
		return sb.toString();
		
		//return "Weather [city=" + city + ", condition=" + condition + ", maxTemperature=" + maxTemperature
		//		+ ", minTemperature=" + minTemperature + ", date=" + date + "]";
	}
	
	
	
	

}

