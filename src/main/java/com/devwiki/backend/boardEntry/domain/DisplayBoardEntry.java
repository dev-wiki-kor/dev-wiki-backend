package com.devwiki.backend.boardEntry.domain;

import java.time.LocalDateTime;
import java.util.Set;

import com.devwiki.backend.article.domain.article.ArticleType;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*
* ES 조회에 표시되는 데이터
* -> 문서 content 는 없음 .
* */

@Getter
@AllArgsConstructor(staticName = "of")
public class DisplayBoardEntry {

	private String documentId;

	private ArticleType articleType;

	private Long articleId;

	private LocalDateTime articleUpdatedDate;

	private LocalDateTime articleEdittedDate;

	private Long editorId;

	private Long uploaderId;

	private Long version;

	private String title ;

	private Set<String> tags;
}
