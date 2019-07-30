package com.springApp.hotelApi.request;

import java.util.Date;

public class TotalPriceRequest {

	private String cityCode; 
	private Date checkin; 
	private Date checkout; 
	private String numAdult;
	private String numChild;
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getNumAdult() {
		return numAdult;
	}
	public void setNumAdult(String numAdult) {
		this.numAdult = numAdult;
	}
	public String getNumChild() {
		return numChild;
	}
	public void setNumChild(String numChild) {
		this.numChild = numChild;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}


	

	
	
}
