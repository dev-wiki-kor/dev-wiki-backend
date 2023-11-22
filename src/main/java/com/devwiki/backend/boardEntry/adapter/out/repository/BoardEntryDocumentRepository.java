package com.devwiki.backend.boardEntry.adapter.out.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devwiki.backend.boardEntry.adapter.out.document.BoardEntryDocument;

@Repository
public interface BoardEntryDocumentRepository extends ElasticsearchRepository<BoardEntryDocument, String> {

	@Query(
		"{\n"
			+ "  \"query\": {\n"
			+ "    \"bool\": {\n"
			+ "      \"should\": [\n"
			+ "        {\"match\": {\"title\": \"?0\"}},\n"
			+ "        {\"match\": {\"content\": \"?0\"}},\n"
			+ "        {\"match\": {\"tags\": \"?0\"}}\n"
			+ "      ],\n"
			+ "      \"must\": [\n"
			+ "        {\"match\": {\"tags\": \"?2\"}}\n"
			+ "      ],\n"
			+ "      \"must\": [\n"
			+ "        {\"term”: {\"editorId\": \"?1\"}}\n"
			+ "      ]\n"
			+ "    }\n"
			+ "  }\n"
			+ "}\n"
	)
	List<BoardEntryDocument> searchWithEditorIdAndTags(@Param("searchWord") String searchWord, @Param("editorId") Long editorId, @Param("tags") String tags);

	@Query(
		"{\n"
			+ "    \"bool\": {\n"
			+ "      \"should\": [\n"
			+ "        {\"match\": {\"title\": \"?0\"}},\n"
			+ "        {\"match\": {\"content\": \"?0\"}},\n"
			+ "        {\"match\": {\"tags\": \"?0\"}}\n"
			+ "      ],\n"
			+ "      \"must\": [\n"
			+ "        {\"match\": {\"tags\": \"?1\"}}\n"
			+ "      ]\n"
			+ "    }\n"
			+ "}\n"
	)
	List<BoardEntryDocument> searchWithTags(@Param("searchWord") String searchWord,  @Param("tags") String tags);



	@Query(
		"{\n"
			+ "    \"bool\": {\n"
			+ "      \"should\": [\n"
			+ "        {\"match\": {\"title\": \"?0\"}},\n"
			+ "        {\"match\": {\"content\": \"?0\"}},\n"
			+ "        {\"match\": {\"tags\": \"?0\"}}\n"
			+ "      ],\n"
			+ "      \"must\": [\n"
			+ "        {\"term\": {\"editorId\": \"?1\"}}\n"
			+ "      ]\n"
			+ "    }\n"
			+ "}\n"
	)
	List<BoardEntryDocument> searchWithEditorId(@Param("searchWord") String searchWord, @Param("editorId")  Long editorId);

	@Query(
		"{\n"
			+ "  \"query\": {\n"
			+ "    \"bool\": {\n"
			+ "      \"should\": [\n"
			+ "        {\"match\": {\"title\": \"?0\"}},\n"
			+ "        {\"match\": {\"content\": \"?0\"}},\n"
			+ "        {\"match\": {\"tags\": \"?0\"}}\n"
			+ "      ]\n"
			+ "    }\n"
			+ "  }\n"
			+ "}\n"
	)
	List<BoardEntryDocument> search( @Param("searchWord") String searchWord);

}
