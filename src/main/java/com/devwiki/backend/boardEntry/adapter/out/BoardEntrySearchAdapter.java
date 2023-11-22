package com.devwiki.backend.boardEntry.adapter.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devwiki.backend.boardEntry.adapter.out.repository.BoardEntryDocumentRepository;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchParams;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchPort;
import com.devwiki.backend.boardEntry.domain.DisplayBoardEntry;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class BoardEntrySearchAdapter implements BoardEntrySearchPort {

	private final BoardEntryDocumentRepository repository;

	/**
	 * @param params : 검색 조회 조건 dto ( searchWord: String, editorId: Long, tags: set )
	 * @return List<DisplayBoardEntry>: 조회 도메인 리스트 리턴 .
	 *
	 * ES 문서 검색 쿼리 어댑터.
	 *
	 * -> 현재 Spring data elasitcsearch 5 버전의 dsl 기능들이 많이 없음 ( boolQuery(), Criteria 등 ...  ) 이후 수정 필요.
	 */
	@Override
	public List<DisplayBoardEntry> search(BoardEntrySearchParams params) {

		// tag, author 둘 다 없으면 텍스트만 검색
		if (params.emptyAuthor() && params.emptyTags())
			return repository.search(params.getSearchWord())
				.stream().map(e -> BoardEntryMapper.toDisplayDomain(e)).collect(Collectors.toList());

		// EditorId 만 있으면
		if (params.emptyTags())
			return repository.searchWithEditorId(params.getSearchWord(), params.getEditorId())
				.stream().map(e -> BoardEntryMapper.toDisplayDomain(e)).collect(Collectors.toList());

		// tags 만 있으면
		if (params.emptyAuthor())
			return repository.searchWithTags(params.getSearchWord(), params.getTags().toString())
				.stream().map(e -> BoardEntryMapper.toDisplayDomain(e)).collect(Collectors.toList());

		// 둘다 있으면
		return repository.searchWithEditorIdAndTags(
				params.getSearchWord(),
				params.getEditorId(),
				params.getTags().toString()
			)
			.stream().map(e -> BoardEntryMapper.toDisplayDomain(e)).collect(Collectors.toList());
	}
}
