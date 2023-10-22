package com.devwiki.backend.exception;

public class FileInvalidException extends WebException {

    public static final String DEFAULT = "Invalid File : %s";

    public FileInvalidException(String message, String fileName) {
        super(String.format(message, fileName));
    }
}
