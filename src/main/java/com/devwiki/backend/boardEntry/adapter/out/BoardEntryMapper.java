package com.devwiki.backend.boardEntry.adapter.out;

import com.devwiki.backend.boardEntry.adapter.out.document.BoardEntryDocument;
import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

public class BoardEntryMapper {

	public static DisplayBoardEntry toDisplayDomain(BoardEntryDocument document){
		return DisplayBoardEntry.of(
			document.getId(),
			document.getArticleType(),
			document.getArticleId(),
			document.getArticleUpdatedDate(),
			document.getArticleEdittedDate(),
			document.getEditorId(),
			document.getUploaderId(),
			document.getVersion(),
			document.getTitle(),
			document.getTags()
		);
	}
}
