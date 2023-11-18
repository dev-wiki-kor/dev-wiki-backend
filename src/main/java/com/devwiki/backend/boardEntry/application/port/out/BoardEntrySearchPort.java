package com.devwiki.backend.boardEntry.application.port.out;

import java.util.List;

import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

public interface BoardEntrySearchPort {

	public List<DisplayBoardEntry> search(BoardEntrySearchParams params);

}
