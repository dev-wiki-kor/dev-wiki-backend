package com.devwiki.backend.boardEntry.adapter.out.document;

import static org.springframework.data.elasticsearch.annotations.FieldType.Long;
import static org.springframework.data.elasticsearch.annotations.FieldType.*;

import java.lang.Long;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.elasticsearch.annotations.ValueConverter;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.common.es.converter.CustomLocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
//@Mapping(mappingPath = "es/BoardEntryMapping.json")
//@Setting(settingPath = "es/BoardEntrySetting.json")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntryDocument {

	/*
	id 규칙 : {type}_{articleId}
	-> 업데이트에 사용 ( search 쿼리보다 id 하나 찍고 가는게 빠름 )
	* */
	private @Id
	@ReadOnlyProperty String id;

	@Field(type = Keyword, name = "article_type")
	private ArticleType articleType;

	@Field(type = Keyword, name = "article_id")
	private Long articleId;

	//date_time_no_millis("uuuu-MM-dd'T'HH:mm:ssVV"),
	@Field(type = FieldType.Date, pattern = "uuuu-MM-dd HH:mm:ss", name = "article_updated_date")
	@ValueConverter(CustomLocalDateTimeConverter.class)
	private LocalDateTime articleUpdatedDate;

	//date_time_no_millis("uuuu-MM-dd'T'HH:mm:ssVV"),
	@Field(type = FieldType.Date, pattern = "uuuu-MM-dd HH:mm:ss", name = "article_editted_date")
	@ValueConverter(CustomLocalDateTimeConverter.class)
	private LocalDateTime articleEdittedDate;

	@Field(type = Keyword, name = "editor_id")
	private Long editorId;

	@Field(type = Keyword, name = "uploader_id")
	private Long uploaderId;

	@Field(type = Long, name = "version")
	private Long version;

	@Field(type = Text, name = "title")
	private String title;

	@Field(type = Text, name = "tags")
	private Set<String> tags;

	@Field(type = Text, name = "content")
	private String content;

}
