package com.devwiki.backend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.devwiki.backend.article.articleDetail.ArticleDetail;


@SpringBootApplication
public class BackendApplication  {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
