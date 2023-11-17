package com.devwiki.backend.article.domain;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum ArticleType {

	TRANSLATION, ENGINEERING;

	private static final Map<String, ArticleType> stringToEnum
		= Stream.of(values()).collect(toMap(Object::toString, e -> e));

	public static Optional<ArticleType> fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol));
	}
}
