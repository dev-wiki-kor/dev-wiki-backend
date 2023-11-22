package com.devwiki.backend.common.es.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.elasticsearch.core.mapping.PropertyValueConverter;

import jodd.typeconverter.TypeConversionException;

public class CustomLocalDateTimeConverter implements PropertyValueConverter {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

	@Override
	public Object write(Object value) {
		if (value instanceof LocalDateTime)
			return ((LocalDateTime)value).format(formatter);
		throw new TypeConversionException("can not convert to 'LocalDateTime : '" + value.toString());

	}

	@Override
	public Object read(Object value) {
		if (value instanceof String)
			return LocalDateTime.parse(((String)value), formatter);
		throw new TypeConversionException("can not convert to 'String' : " + value.toString());

	}
}
