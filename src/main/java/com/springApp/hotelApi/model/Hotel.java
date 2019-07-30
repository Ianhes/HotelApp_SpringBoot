package com.springApp.hotelApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.springApp.hotelApi.response.TotalPriceResponse;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
	
	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("cityCode")
	@Expose
	private int cityCode;
	@SerializedName("cityName")
	@Expose
	private String cityName;
	@SerializedName("rooms")
	@Expose
	private List<Room> rooms;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
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
	
	public TotalPriceResponse hotelToResponse() {
		
		TotalPriceResponse response = new TotalPriceResponse();
		response.setCityName(this.cityName);
		response.setId(this.id);
		response.setRooms(this.rooms);
		return response;
	}
	
	
}
