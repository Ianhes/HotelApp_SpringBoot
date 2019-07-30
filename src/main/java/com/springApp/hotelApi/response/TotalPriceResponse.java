package com.springApp.hotelApi.response;

import java.util.List;

import com.springApp.hotelApi.model.Room;

public class TotalPriceResponse {

	private int id;
	private String cityName;
	private List<Room> rooms;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
}
