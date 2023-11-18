package com.devwiki.backend.boardEntry.adapter.out;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devwiki.backend.boardEntry.adapter.out.repository.BoardEntryDocumentRepository;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchParams;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchPort;
import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoardEntrySearchAdapter implements BoardEntrySearchPort {

	BoardEntryDocumentRepository documentRepository;
	@Override
	public List<DisplayBoardEntry> search(BoardEntrySearchParams params) {
		/*
		var documentList  = documentRepository.termQuery();

		List<DisplayBoardEntry> displayBoardEntries
			= documentList.stream().map(e->BoardEntryMapper.toDisplayDomain(e)).collect(Collectors.toList());

		return displayBoardEntries;

		 */

		return null;
	}
}
