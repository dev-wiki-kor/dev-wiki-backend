package com.devwiki.backend.article.adapter.out;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ArticleEditAdapterTest {

    private static String LOCK_RELEASED_BY_ORDER_THREAD_MESSAGE = "java.lang.IllegalMonitorStateException: attempt to unlock lock, not locked by current thread by";

    @Autowired
    ArticleEditAdapter articleEditAdapter;

    @Test
    @Sql(scripts = {"classpath:ArticleTestSample.sql"})
    void 편집_성공(){
        var v2 = articleEditAdapter.editArticle(
                ArticleEdit.of(ArticleType.TRANSLATION.name(),100L,1L,1L," content 1+ ")
        );
        assertEquals(2,v2.version());

        var v3 = articleEditAdapter.editArticle(
                ArticleEdit.of(ArticleType.TRANSLATION.name(),100L,1L,2L," content 2+ ")
        );
        assertEquals(3,v3.version());

        var v_2 = articleEditAdapter.editArticle(
                ArticleEdit.of(ArticleType.TRANSLATION.name(),100L,2L,1L," content 2+ ")
        );
        assertEquals(2,v_2.version());
    }

    @Test
    @Sql(scripts = {"classpath:ArticleTestSample.sql"})
    void 편집_실패_없는_문서(){
        assertThrows(RuntimeException.class,()->
                articleEditAdapter.editArticle(
                        ArticleEdit.of(ArticleType.TRANSLATION.name(),100L,100L,1L,"this will fail")
                ));
    }
    @Test
    @Sql(scripts = {"classpath:ArticleTestSample.sql"})
    void 동시성_테스트_편집_id_생성_성공() throws ExecutionException,InterruptedException{
        int iteration =100;

        List<CompletableFuture> completableFutureList=
                IntStream.range(0,iteration)
                        .mapToObj(e -> CompletableFuture.supplyAsync(()->
                                tryEdit(ArticleEdit.of(
                                        ArticleType.TRANSLATION.name(),100L,1L,1L,"editted : " + e
                                ))))
                        .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                completableFutureList.toArray(new CompletableFuture[iteration])
        );

        allOf.join();

        Set setOfVersion = new HashSet<>();
        for(CompletableFuture future:completableFutureList)
            setOfVersion.add(future.get());

        assertEquals(iteration,setOfVersion.size());
        for(long v=2L;v<=1 + iteration;v++)
            if(!setOfVersion.contains(v))
                throw new RuntimeException("해당 버전이 없음 : " +v);


    }

    private Long tryEdit(ArticleEdit articleEdit){
        return articleEditAdapter.editArticle(articleEdit).version();
    }
}

