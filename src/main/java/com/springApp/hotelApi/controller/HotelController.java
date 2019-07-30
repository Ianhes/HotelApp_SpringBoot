package com.springApp.hotelApi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springApp.hotelApi.model.Hotel;
import com.springApp.hotelApi.request.TotalPriceRequest;
import com.springApp.hotelApi.response.TotalPriceResponse;
import com.springApp.hotelApi.service.HotelService;
import com.springApp.hotelApi.validator.RequestValidator;

@Controller
public class HotelController {

	@Autowired
	private HotelService service;
	
	@Autowired
	private RequestValidator rv;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form() {
		return "formHotel";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView form (TotalPriceRequest request, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("listHotel");
		}

		ModelAndView mv = new ModelAndView("listHotel");
		Iterable<TotalPriceResponse> iterable = this.service.getRequestForm(request);
		mv.addObject("hoteis", iterable);

		return mv;
	}
	

	@RequestMapping(value = "/hotelByCity/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Hotel>> hotelByCity(@PathVariable String id) {

		return this.service.hotelForIdCity(id);
	}

	@RequestMapping(value = "/totalPriceHotels", params = { "city", "checkin", "checkout", "numAdult",
			"numChild" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TotalPriceResponse>> totalPriceHotels(@RequestParam("city") String city,
			@RequestParam("checkin") String checkin, @RequestParam("checkout") String checkout,
			@RequestParam("numAdult") String numAdult, @RequestParam("numChild") String numChild) {

		return this.service.totalPrice(checkin, checkout, city, numAdult, numChild);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(rv);
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor formDate = new CustomDateEditor(dateFormat1, true);
	
		binder.registerCustomEditor(Date.class, formDate);

	}

}
