package com.devwiki.backend.boardEntry.adapter.out;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.boardEntry.adapter.out.document.BoardEntryDocument;
import com.devwiki.backend.boardEntry.adapter.out.repository.BoardEntryDocumentRepository;
import com.devwiki.backend.boardEntry.application.port.out.BoardEntrySearchParams;
import com.devwiki.backend.testUtil.MonkeyUtil;

@SpringBootTest
class BoardEntrySearchAdapterTest {

	@Autowired
	BoardEntryDocumentRepository repository;


	@Autowired
	BoardEntrySearchAdapter searchAdapter;

	@Test
	public void 쿼리문_조회(){
		searchAdapter.search(new BoardEntrySearchParams("java",null,Set.of("java")));
	}

	@BeforeEach
	public void saveSampleData(){
		repository.deleteAll();
		List<BoardEntryDocument> docs = getDocs();
		repository.saveAll(docs);
	}


	private List<BoardEntryDocument> getDocs(){
		return
			List.of(
				MonkeyUtil.boardEntryDocument()
					.set("id", ArticleType.TRANSLATION.name() +"_1")
					.set("articleId",1L)
					.set("title", "java good book")
					.set("content", "hello world , java, gradle , monkey utils elasticsearch good ")
					.set("tags", Set.of("java", "language"))
					.sample(),
				MonkeyUtil.boardEntryDocument()
					.set("id", ArticleType.TRANSLATION.name() +"_2")
					.set("articleId",2L)
					.set("title", "elasitcsearch good ")
					.set("content", "hello elasitcsearch , java, but spring data elasticsearch is bad  ")
					.set("tags", Set.of("java", "database"))
					.sample(),
				MonkeyUtil.boardEntryDocument()
					.set("id", ArticleType.TRANSLATION.name() +"_3")
					.set("articleId",3L)
					.set("title", "redis")
					.set("content", "this database use ram , super fast ")
					.set("tags", Set.of("c", "database"))
					.sample(),
				MonkeyUtil.boardEntryDocument()
					.set("id", ArticleType.TRANSLATION.name() +"_4")
					.set("articleId",4L)
					.set("title", "junit")
					.set("content", "junit little bit hard to me , handy though  ")
					.set("tags", Set.of("java", "test", "junit"))
					.sample(),
				MonkeyUtil.boardEntryDocument()
					.set("id", ArticleType.TRANSLATION.name() +"_5")
					.set("articleId",5L)
					.set("title", "empty one")
					.set("content", "")
					.set("tags", Set.of())
					.sample()
			);
	}

}