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

		var editorId = getEditorId(command.editorNickName());

		return boardEntrySearchPort.search(new BoardEntrySearchParams(
			command.searchWord(), editorId, command.tags()
		));
	}

	private Long getEditorId(String nickname) {
		// to-be :  account 완료되면 nickname -> PK 쿼리 하는 것으로
		return Long.valueOf(nickname);
	}
}
