package com.devwiki.backend.article.domain.boardEntry;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.devwiki.backend.article.domain.article.ArticleType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


/*
* 조회용 Document
* */

@Document(indexName = "board_entry")
public class BoardEntry {

	/*
	id 규칙 : {type}_{articleId}
	-> 업데이트에 사용 ( search 쿼리보다 id 하나 찍고 가는게 빠름 )
	* */
	private @Id String id;

	@Enumerated(EnumType.STRING)
	private ArticleType articleType;

	private Long articleId;

	private @Field(type = Date) String articleUpdatedDate;

	private @Field(type = Date) String articleEdittedDate;

	private Long editorId;

	private Long uploaderId;

	private Long version;

	private String title ;

	private Set<String> tags;

	private String conetent;
}
