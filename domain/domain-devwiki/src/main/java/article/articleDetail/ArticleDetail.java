package article.articleDetail;

import java.time.LocalDateTime;
import java.util.List;

import article.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ArticleDetail {

	ArticleMetadata articleMetadata;

	EditorInfo editorInfo;

	String title;

	String article;

	Long version;

	Long likes;

	Long dislikes;


	@AllArgsConstructor(staticName = "of")
	static class EditorInfo {
		String editor;

		String editorGithubUrl;

		LocalDateTime editedAt;
	}

	@AllArgsConstructor(staticName = "of")
	static class ArticleMetadata {

		String uploader;
		ArticleType articleType;

		String sourceUrl;

		LocalDateTime uploadedAt;

		List<String> tags;
	}
}
