package com.devwiki.backend.article.adapter.out.boardEntry.repository;

import org.springframework.data.repository.CrudRepository;

import com.devwiki.backend.article.adapter.out.boardEntry.document.BoardEntryDocument;

public interface BoardEntryDocumentRepository extends CrudRepository<BoardEntryDocument, String> {
}
