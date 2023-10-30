package com.devwiki.backend.article.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.devwiki.backend.article.application.port.in.CreateArticleCommand;
import com.devwiki.backend.article.application.port.out.ArticleCreatePort;
import com.devwiki.backend.article.application.port.out.CountHistoryPort;

class ArticleCreateServiceTest {

	private final ArticleCreatePort articleCreatePort =
		Mockito.mock(ArticleCreatePort.class);

	private final CountHistoryPort countHistoryPort =
		Mockito.mock(CountHistoryPort.class);

	private final ArticleCreateService articleCreateService
		= new ArticleCreateService(articleCreatePort, countHistoryPort);

	@Test
	void empty() {
	}

	@Test
	void 문서_생성_성공() {
		// given
		var cmd = createCommand();
		userHas3History(cmd);
		portWillSuccess();

		//when & then
		articleCreateService.create(cmd);
	}

	@Test
	void 문서_생성_실패_유저_히스토리_초과() {
		//given
		var cmd = createCommand();
		userHas999History(cmd);
		portWillSuccess();

		//when & then
		assertThrows(RuntimeException.class, () -> articleCreateService.create(cmd));
	}

	@Test
	void 문서_생성_실패_어댑터_실패() {
		//given
		var cmd = createCommand();
		userHas3History(cmd);
		portWillFail();

		//when & then
		assertThrows(RuntimeException.class, () -> articleCreateService.create(cmd));
	}

	private void portWillSuccess() {
		doNothing().when(articleCreatePort).createArticle(any());
	}

	private void portWillFail() {
		doThrow(RuntimeException.class).when(articleCreatePort).createArticle(any());
	}

	private void userHas999History(CreateArticleCommand cmd) {
		given(countHistoryPort.countCreate(cmd.uploaderId())).willReturn(999L);
	}

	private void userHas3History(CreateArticleCommand cmd) {
		given(countHistoryPort.countCreate(cmd.uploaderId())).willReturn(3L);

	}

	private CreateArticleCommand createCommand() {
		return CreateArticleCommand.of(1L, "TRANSLATION", "www.com", Set.of(), "title", "content");
	}

}