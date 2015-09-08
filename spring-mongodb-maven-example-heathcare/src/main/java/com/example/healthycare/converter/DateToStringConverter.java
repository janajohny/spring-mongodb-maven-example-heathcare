package com.example.healthycare.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateToStringConverter implements Converter<Date, String>{
	
	@Override
	public String convert(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String result;
		try {
			result = formatter.format(date);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
