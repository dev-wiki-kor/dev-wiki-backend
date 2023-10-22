package com.devwiki.backend.file;

public class FileRepositoryException extends RuntimeException {
    public static final String DELETE = "Failed to delete file: %s";
    public static final String LOAD = "Could not read file: %s";
    public static final String STORE = "Failed to store empty file: %s";

    public FileRepositoryException(String message, String fileName) {
        super(String.format(message, fileName));
    }


}
