package com.devwiki.backend.file.business;

import com.devwiki.backend.exception.BusinessException;

public class FileProcessorException extends BusinessException {
    public static final String DEFAULT = "Failed to store file";
    public static final String DELETE = "Failed to delete file at path: %s";
    public static final String LOAD = "Could not load file: %s";
    public static final String OUTSIDE_STORE = "Cannot file with relative path outside current directory %s";
    public static final String INVALID_FILE = "Failed to store file %s";

    public FileProcessorException(String message, String metaData) {
        super(String.format(message, metaData));
    }

}
