package com.devwiki.backend.file.port.in;

import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.model.StorageType;

public interface FileStoreUseCase {
    void storeFile(StorageType type, FileHolder fileHolder);
}
