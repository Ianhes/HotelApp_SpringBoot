package com.springApp.hotelApi.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springApp.hotelApi.request.TotalPriceRequest;

@Component
public class RequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return TotalPriceRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TotalPriceRequest request = (TotalPriceRequest)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityCode", "","Não pode ser vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkin", "", "Não pode ser vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkout", "", "Não pode ser vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numAdult", "", "Não pode ser vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numChild", "", "Não pode ser vazio");
		
	}

	
	
	
}
