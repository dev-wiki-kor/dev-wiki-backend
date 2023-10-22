package com.devwiki.backend.file.model;

import com.devwiki.backend.file.model.StorageType;

public record FileMetadata(
        Long id,

        StorageType storageType,

        String filename,

        String url,

        long size
) {
}

