package com.devwiki.backend.storage.article.repository;

import com.devwiki.backend.storage.article.entity.RedisTestMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedisTestMetadataRepository extends JpaRepository<RedisTestMetadata, Long> {

    RedisTestMetadata findBytitle(String title);

}
