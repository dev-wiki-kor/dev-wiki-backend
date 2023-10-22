package com.devwiki.backend.file.port.in;

import com.devwiki.backend.file.model.StorageType;

import java.io.File;

public interface FileLoadUseCase {
    File loadFile(StorageType type, String fileName);
}
