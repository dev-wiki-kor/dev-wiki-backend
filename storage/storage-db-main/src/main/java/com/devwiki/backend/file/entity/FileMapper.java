package com.devwiki.backend.file.entity;

import com.devwiki.backend.file.business.model.FileMetadata;
import com.devwiki.backend.file.entity.FileMetadataEntity;
import org.springframework.stereotype.Component;

@Component
class FileMapper {
    FileMetadata toDomain(FileMetadataEntity entity) {
        return new FileMetadata(
                entity.getId(),
                entity.getStorageType(),
                entity.getFilename(),
                entity.getUrl(),
                entity.getSize()
        );
    }

    FileMetadataEntity toEntity(FileMetadata fileMetadata) {
        return new FileMetadataEntity(
                fileMetadata.storageType(),
                fileMetadata.filename(),
                fileMetadata.url(),
                fileMetadata.size()
        );
    }
}
