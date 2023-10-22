package com.devwiki.backend.file.business.exception;

public class FileProcessorException extends RuntimeException {
    public static final String DEFAULT = "Failed to store com.devwiki.backend.file";
    public static final String DELETE = "Failed to delete com.devwiki.backend.file at path: %s";
    public static final String LOAD = "Could not load com.devwiki.backend.file: %s";
    public static final String OUTSIDE_STORE = "Cannot store com.devwiki.backend.file with relative path outside current directory %s";
    public static final String INVALID_FILE = "Failed to store invalid com.devwiki.backend.file %s";

    public FileProcessorException(String message, String metaData) {
        super(String.format(message, metaData));
    }

}
