package com.devwiki.backend.boardEntry.application.port.out;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoardEntrySearchParams {
	private String searchWord;
	private Long editorId;
	private Set<String> tags;

	public boolean emptyAuthor() {
		return editorId == null;
	}

	public boolean emptyTags() {
		return
			tags == null
				|| tags.size() == 0
				|| tags.stream().filter(e -> !e.isBlank()).collect(Collectors.toList()).size() == 0;
	}

	public boolean emptySearchword() {
		return searchWord == null || searchWord.isBlank();
	}
}
