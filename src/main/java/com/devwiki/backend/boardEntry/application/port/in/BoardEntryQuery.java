package com.devwiki.backend.boardEntry.application.port.in;

import java.util.List;

import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

public interface BoardEntryQuery {
	List<DisplayBoardEntry> search(BoardEntryQueryCommand command);
}
