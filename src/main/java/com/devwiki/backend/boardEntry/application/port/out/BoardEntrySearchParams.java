package com.devwiki.backend.boardEntry.application.port.out;

import java.util.Set;

public record BoardEntrySearchParams(
	String searchWord,
	String author,
	Set<String> tags
) {
}
