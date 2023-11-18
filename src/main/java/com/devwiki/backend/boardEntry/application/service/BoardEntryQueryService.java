package com.devwiki.backend.boardEntry.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devwiki.backend.boardEntry.application.port.in.BoardEntryQuery;
import com.devwiki.backend.boardEntry.application.port.in.BoardEntryQueryCommand;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchParams;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchPort;
import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardEntryQueryService implements BoardEntryQuery {

	private final BoardEntrySearchPort boardEntrySearchPort;
	@Override
	public List<DisplayBoardEntry> search(BoardEntryQueryCommand command) {

		return boardEntrySearchPort.search(new BoardEntrySearchParams(
			command.searchWord(), command.author(), command.tags()
		));
	}
}
