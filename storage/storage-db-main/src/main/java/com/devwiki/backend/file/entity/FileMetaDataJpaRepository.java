package com.devwiki.backend.file.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileMetaDataJpaRepository extends JpaRepository<FileMetadataEntity, Long> {
    Optional<FileMetadataEntity> findByUrl(String url);
}
