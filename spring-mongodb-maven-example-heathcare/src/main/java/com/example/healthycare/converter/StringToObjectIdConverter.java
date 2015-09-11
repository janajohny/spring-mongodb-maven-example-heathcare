package com.example.healthycare.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

public class StringToObjectIdConverter  implements Converter<String, ObjectId>{

	@Override
	public ObjectId convert(String input) {
		return new ObjectId(input);
	}

}
