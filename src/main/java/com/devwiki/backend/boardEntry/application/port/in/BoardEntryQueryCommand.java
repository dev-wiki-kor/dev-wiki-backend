package com.devwiki.backend.boardEntry.application.port.in;

import java.util.Set;

public record BoardEntryQueryCommand(
	String searchWord,
	String author,
	Set<String> tags
) {
}
