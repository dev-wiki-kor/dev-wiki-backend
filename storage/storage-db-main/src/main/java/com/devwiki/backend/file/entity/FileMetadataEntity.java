package com.devwiki.backend.file.entity;

import com.devwiki.backend.BaseTimeEntity;
import com.devwiki.backend.file.model.StorageType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileMetadataEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StorageType storageType;

    @Column(nullable = false, unique = true)
    private String filename; // 이름 및 확장자 포함, 상위 경로 포함

    @Column(nullable = false, unique = true)
    private String url;

    @Column(nullable = false)
    private long size;

    public FileMetadataEntity(StorageType storageType, String filename, String url, long size) {
        this.storageType = storageType;
        this.filename = filename;
        this.url = url;
        this.size = size;
    }

}
