package com.devwiki.backend.file.exception;

import com.devwiki.backend.exception.BusinessException;

public class FileInvalidException extends BusinessException {
    public final String DEFAULT = "Failed to store com.devwiki.backend.file";
    public final String DELETE = "Failed to delete com.devwiki.backend.file at path: %s";
    public final String LOAD = "Could not load com.devwiki.backend.file: %s";
    public final String OUTSIDE_STORE = "Cannot store com.devwiki.backend.file with relative path outside current directory %s";
    public final String INVALID_FILE = "Failed to store invalid com.devwiki.backend.file %s";

    public FileInvalidException(String message, String metaData) {
        super(String.format(message, metaData));
    }

}
