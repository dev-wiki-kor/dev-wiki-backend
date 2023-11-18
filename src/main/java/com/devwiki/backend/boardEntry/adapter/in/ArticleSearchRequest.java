package com.devwiki.backend.boardEntry.adapter.in;

import java.util.Set;

public record ArticleSearchRequest(
	String searchWord,
	String author,
	Set<String> tags

) {
}
