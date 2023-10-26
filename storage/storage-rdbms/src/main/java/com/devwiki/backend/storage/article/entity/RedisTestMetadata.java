package com.devwiki.backend.storage.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class RedisTestMetadata {

    @Id
    private Long id;
    private String title;
    private String team;

}
