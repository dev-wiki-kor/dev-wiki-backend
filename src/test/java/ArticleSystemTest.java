import static org.assertj.core.api.BDDAssertions.*;
import static org.springframework.test.util.AssertionErrors.*;

import java.net.http.HttpRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.devwiki.backend.App;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
public class ArticleSystemTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	@Sql(scripts = {"classpath:ArticleDetailAdapterTest.sql"})
	void 통합__문서_조회_성공() {

		ResponseEntity response = whenQueryDocument(1L, 1L);

		then(response.getStatusCode().isSameCodeAs(HttpStatus.OK));

		System.out.println("json : " + response.getBody());

		// TODO : 도메인 객체 바로 리턴하지 말고 송신용 DTO 별도로 만들기 ...(아래 예시는 default 생성자가 없어서 매핑 안됨 )
		/*
		ArticleDetail result = objectMapper.convertValue(response.getBody(), ArticleDetail.class);

		assertThat(result.getTitle()).isEqualTo("Sample Article ");
		assertThat(result.getArticle()).isEqualTo("This is the content of Article 1");
		 */
	}

	private ResponseEntity whenQueryDocument(Long articleId, Long version) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<Void> request = new HttpEntity<>(null, headers);

		return restTemplate.exchange("/article/detail?articleId={articleId}&version={version}"
			, HttpMethod.GET
			, request
			, Object.class
			, articleId, version
		);
	}

}
