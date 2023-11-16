package com.devwiki.backend.article.adapter.out;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.devwiki.backend.article.adapter.out.article.ArticleEditAdapter;
import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

@SpringBootTest
	/*
	 * TODO : bean 범위 줄이기 : 해당 클래스는 aop, jpa, redis configure 등 엮인게 많음.
	 *  -> 수동으로 configuration 필요.
	 * */
class ArticleEditAdapterTest {

	private static String LOCK_RELEASED_BY_OTHER_THREAD_MESSAGE = "java.lang.IllegalMonitorStateException: attempt to unlock lock, not locked by current thread by";
	@Autowired
	ArticleEditAdapter articleEditAdapter;

	@Test
	@Sql(scripts = {"classpath:ArticleTestSample.sql"})
	void 편집_성공() {
		var v2 = articleEditAdapter.editArticle(
			ArticleEdit.of(ArticleType.TRANSLATION.name(), 100L, 1L, 1L, " content 1+ ")
		);
		assertEquals(2, v2.version());

		var v3 = articleEditAdapter.editArticle(
			ArticleEdit.of(ArticleType.TRANSLATION.name(), 100L, 1L, 2L, " content 2+ ")
		);
		assertEquals(3, v3.version());

		var v_2 = articleEditAdapter.editArticle(
			ArticleEdit.of(ArticleType.TRANSLATION.name(), 100L, 2L, 1L, " content 2+ ")
		);
		assertEquals(2, v_2.version());
	}

	@Test
	@Sql(scripts = {"classpath:ArticleTestSample.sql"})
	void 편집_실패_없는_문서() {
		assertThrows(RuntimeException.class, () ->
			articleEditAdapter.editArticle(
				ArticleEdit.of(ArticleType.TRANSLATION.name(), 100L, 100L, 1L, " this will fail")
			));
	}

	@Test
	@Sql(scripts = {"classpath:ArticleTestSample.sql"})
		/*
		 * id 채번이 비동기 수행시에도 순서를 보장함을 확인 .
		 * */
	void 동시성_테스트_편집_id_생성_성공() throws ExecutionException, InterruptedException {

		// given  : 1000 회의 반복
		// 1000 회 -> 100 회 : 오래 걸려서 수정 (!) -> bean 등록 빨리 바꿔야함.
		int ITERATION = 100;

		//when  : 문서에 대한 버전생성을 {iteration} 만큼 비동기로 수행
		List<CompletableFuture> completableFutureList =
			IntStream.range(0, ITERATION)
				.mapToObj(e -> CompletableFuture.supplyAsync(() ->
					tryEdit(ArticleEdit.of(
						ArticleType.TRANSLATION.name(), 100L, 1L, 1L, "edited : " + e
					))))
				.collect(Collectors.toList());

		CompletableFuture<Void> allOf = CompletableFuture.allOf(
			completableFutureList.toArray(new CompletableFuture[ITERATION])
		);

		// 모든 요청이 종료될때까지 대기.
		allOf.join();

		// then : 검증
		Set setOfVersions = new HashSet();
		for (CompletableFuture future : completableFutureList)
			setOfVersions.add(future.get());

		// 유니크한 아이디 갯수.
		assertEquals(ITERATION, setOfVersions.size());
		for (long v = 2L; v <= 1 + ITERATION; v++) {
			if (!setOfVersions.contains(v))
				throw new RuntimeException("해당 버전이 없음 : " + v);
		}
	}

	private Long tryEdit(ArticleEdit articleEdit) {
		return articleEditAdapter.editArticle(articleEdit).version();
	}
}