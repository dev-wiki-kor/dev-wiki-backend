package com.devwiki.backend.file.model;

import java.io.InputStream;

public record FileHolder(
        InputStream fileInputStream,
        String fileName,
        String fileUrl,
        String contentType,
        String extension,
        long fileSize
) {
}
