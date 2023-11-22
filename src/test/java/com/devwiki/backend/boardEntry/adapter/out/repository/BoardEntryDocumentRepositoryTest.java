package com.devwiki.backend.boardEntry.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// TODO: 의존성 땡겨오는 범위 조정 필요 .
@SpringBootTest
class BoardEntryDocumentRepositoryTest {

	@Autowired
	BoardEntryDocumentRepository boardEntryDocumentRepository;


	@Test
	public void empty(){
		assertNotNull(boardEntryDocumentRepository);
	};



}