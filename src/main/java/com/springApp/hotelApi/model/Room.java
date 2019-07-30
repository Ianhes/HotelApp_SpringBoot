package com.springApp.hotelApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", categoryName=" + categoryName + ", price=" + price + "]";
	}
	@SerializedName("roomID")
	@Expose
	private int roomID;
	@SerializedName("categoryName")
	@Expose
	private String categoryName;
	@SerializedName("price")
	@Expose
	private Price price;

	
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	
	
}
