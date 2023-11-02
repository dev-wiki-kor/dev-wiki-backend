package com.devwiki.backend.article.adapter.out;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.ArticleEditPort;
import com.devwiki.backend.article.application.port.out.GeneratedVersion;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleEditAdapter implements ArticleEditPort {

	private final ArticleVersionContentRepository articleVersionContentRepository;

	private final RedissonClient redissonClient;
	@Override
	public GeneratedVersion editArticle(ArticleEdit articleEdit) {



		Long currVersion = 0L;
		//키 이름은 오피셜 도큐먼트의 ID를 이름으로 설정
		RLock lock = redissonClient.getLock("article_id{"+articleEdit.getArticleId()+"}");

		try{
			Long newVersion = articleVersionContentRepository.getLastVersion(articleEdit.getArticleId())
					.orElseThrow(() -> new RuntimeException("no article metadata exist "));

			var newContent = ArticleVersionContent.of(articleEdit.getArticleId(), newVersion, articleEdit.getEditorId(),
					articleEdit.getContent());

			articleVersionContentRepository.save(ArticleVersionContent.of(
					articleEdit.getArticleId(),
					newVersion,
					articleEdit.getEditorId(),
					articleEdit.getContent()
			));
			currVersion = newVersion;
		} catch (RuntimeException e){
			//에러 발생 시 락이 되어있는지를 먼저 체크
			if(lock.isLocked()){
				lock.unlock();
				throw new RuntimeException("locking after fail");
			}else{
				throw new RuntimeException("locking fail");
			}


		} finally {
			lock.unlock();
		}



		return new GeneratedVersion(currVersion);
	}
}
