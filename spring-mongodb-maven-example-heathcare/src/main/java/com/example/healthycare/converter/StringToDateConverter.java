package com.example.healthycare.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date;
		try {
			date = formatter.parse(source);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
