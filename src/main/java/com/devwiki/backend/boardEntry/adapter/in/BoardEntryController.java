package com.devwiki.backend.boardEntry.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.boardEntry.application.port.in.BoardEntryQuery;
import com.devwiki.backend.boardEntry.application.port.in.BoardEntryQueryCommand;
import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/boardEntry")
@RequiredArgsConstructor
public class BoardEntryController {

	private final BoardEntryQuery boardEntryQuery;

	@PostMapping("/search")
	public ResponseEntity searchBoardEntry(@RequestBody ArticleSearchRequest articleSearchRequest) {

		List<DisplayBoardEntry> entries = boardEntryQuery.search(new BoardEntryQueryCommand(
			articleSearchRequest.searchWord(),
			articleSearchRequest.author(),
			articleSearchRequest.tags()
		));

		return ResponseEntity.ok(entries);
	}
}
