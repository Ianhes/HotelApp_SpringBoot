package com.springApp.hotelApi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.springApp.hotelApi.model.Hotel;
import com.springApp.hotelApi.model.Room;
import com.springApp.hotelApi.request.TotalPriceRequest;
import com.springApp.hotelApi.response.TotalPriceResponse;

@Service
public class HotelService {

	private final String URL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	private final double kickback = 0.7;

	public ResponseEntity<List<Hotel>> hotelForIdCity(String idCity) {

		ResponseEntity<String> hoteis = readJson(idCity);

		String json = hoteis.getBody();
		JSONArray array = new JSONArray(json);
		Gson gson = new Gson();
		Hotel[] receiver = gson.fromJson(array.toString(), Hotel[].class);

		List<Hotel> receiverList = new ArrayList<>(Arrays.asList(receiver));

		return new ResponseEntity<>(receiverList, HttpStatus.OK);
	}

	public ResponseEntity<List<TotalPriceResponse>> totalPrice(String checkin, String checkout, String cityCode,
			String numAdult, String numChild) {

		ResponseEntity<List<Hotel>> allHotels = hotelForIdCity(cityCode);
		List<TotalPriceResponse> totalPriceHotel = new ArrayList<>();

		int adult = Integer.valueOf(numAdult);
		int child = Integer.valueOf(numChild);
		long numDays = 0;

		for (Hotel hotel : allHotels.getBody()) {

			for (Room room : hotel.getRooms()) {
				numDays = calcDays(checkin, checkout);
				room.getPrice().setTotalPrice(calcTotalPrice(adult, child, numDays, room));
			}
			totalPriceHotel.add(hotel.hotelToResponse());
		}
		return new ResponseEntity<>(totalPriceHotel, HttpStatus.OK);
	}

	private double calcTotalPrice(int adult, int child, long numDays, Room room) {
		double priceAdult;
		double priceChild;

		priceAdult = (room.getPrice().getAdult() * numDays) / this.kickback;
		priceChild = (room.getPrice().getChild() * numDays) / this.kickback;

		return (priceAdult * adult) + (priceChild * child);
	}

	private long calcDays(String checkin, String checkout) {
		Date in = null;
		Date out = null;

		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

		try {
			in = format.parse(checkin);
			out = format.parse(checkout);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (out.getTime() - in.getTime() + 3600000L) / 86400000L;
	}

	private ResponseEntity<String> readJson(String id) {
		String uri = URL.concat("avail//");
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return rt.exchange(uri.concat(id), HttpMethod.GET, entity, String.class);

	}

	public List<TotalPriceResponse> getRequestForm(TotalPriceRequest request) {
		
		String in = new SimpleDateFormat().format(request.getCheckin());
		String out = new SimpleDateFormat().format(request.getCheckout());
		return totalPrice(in, out, request.getCityCode(), request.getNumAdult(), request.getNumChild()).getBody();

	}

}
