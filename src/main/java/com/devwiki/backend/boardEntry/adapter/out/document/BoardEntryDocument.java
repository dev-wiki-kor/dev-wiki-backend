package com.devwiki.backend.boardEntry.adapter.out.document;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Document(
	indexName = "board_entry",
	dynamic = Dynamic.STRICT,
	createIndex = true
)
@Setting(
	shards = 1,
	replicas = 0
)
@JsonInclude(value = JsonInclude.Include.ALWAYS)
public class BoardEntryDocument {

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

	private @Field(type = Text) String title;

	private @Field(type = Text) Set<String> tags;

	private @Field(type = Text) String content;

}
