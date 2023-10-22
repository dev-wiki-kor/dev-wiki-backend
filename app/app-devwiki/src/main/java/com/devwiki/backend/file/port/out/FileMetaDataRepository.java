package com.devwiki.backend.file.port.out;

import com.devwiki.backend.file.model.FileMetadata;

import java.util.Optional;

public interface FileMetaDataRepository {
    Optional<FileMetadata> findByUrl(String fileUrl);

    void delete(FileMetadata fileMetadata);

    void save(FileMetadata fileMetadata);
}
