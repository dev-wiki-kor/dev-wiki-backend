package com.devwiki.backend.file.port.out;

import com.devwiki.backend.file.model.FileHolder;

import java.io.File;

public interface FileRepository {
    File load(String fileName);
    void delete(String fileName);
    void store(FileHolder fileHolder);
}
