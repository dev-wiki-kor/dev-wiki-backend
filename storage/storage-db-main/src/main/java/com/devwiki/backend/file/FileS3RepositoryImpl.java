package com.devwiki.backend.file;

import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.port.out.FileS3Repository;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public class FileS3RepositoryImpl implements FileS3Repository {
    @Override
    public File load(String fileName) {
        return null;
    }

    @Override
    public void delete(String fileUrl) {

    }

    @Override
    public void store(FileHolder fileHolder) {

    }
}
