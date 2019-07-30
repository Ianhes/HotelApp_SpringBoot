package com.springApp.hotelApi.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

	@SerializedName("adult")
	@Expose
	private double adult;
	@SerializedName("child")
	@Expose
	private double child;
	private double totalPrice;
	
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public double getAdult() {
		return adult;
	}
	public void setAdult(double adult) {
		this.adult = adult;
	}
	public double getChild() {
		return child;
	}
	public void setChild(double child) {
		this.child = child;
	}
	
	public void setTotalPrice(double totalPrice) {
        BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.FLOOR);
        this.totalPrice = bd.doubleValue();
    }
	
	
}
