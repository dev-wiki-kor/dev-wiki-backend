package com.devwiki.backend.boardEntry.adapter.out.repository;

import org.springframework.data.repository.CrudRepository;

import com.devwiki.backend.boardEntry.adapter.out.document.BoardEntryDocument;

public interface BoardEntryDocumentRepository extends CrudRepository<BoardEntryDocument, String> {
}
