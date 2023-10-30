package com.devwiki.backend.article.adapter.in;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.devwiki.backend.article.application.port.in.ArticleCreateUsecase;
import com.devwiki.backend.article.application.port.in.ArticleDetailQuery;
import com.devwiki.backend.article.application.port.in.ArticleEditUsecase;
import com.devwiki.backend.article.application.service.ArticleDetailQueryHandler;
import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

@WebMvcTest(controllers = ArticleController.class)
class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ArticleDetailQuery articleDetailQuery;

	@MockBean
	ArticleCreateUsecase articleCreateUsecase;

	@MockBean
	ArticleEditUsecase articleEditUsecase;

	@Test
	void 글_조회_성공() throws Exception {
		//given
		var articleDetail = sampleArticle();
		given(articleDetailQuery.query(1L, 1L)).willReturn(articleDetail);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("articleId", "1");
		params.set("version", "1");

		mockMvc.perform(get("/article/detail").params(params))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	void 글_조회_실패_파라미터_없음() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		mockMvc.perform(get("/article/detail").params(params))
			.andExpect(status().is4xxClientError())
			.andDo(print());
	}

	private ArticleDetail sampleArticle() {
		return ArticleDetail.of(
			ArticleDetail.ArticleMetadata.of("uploader", ArticleType.TRANSLATION, "www.url.url", LocalDateTime.now(),
				Set.of("tag1", "tag2")),
			ArticleDetail.EditorInfo.of("editor", "www.editor.com"),
			"title", "content", 1L, 1L, 1L, LocalDateTime.now()
		);
	}
}