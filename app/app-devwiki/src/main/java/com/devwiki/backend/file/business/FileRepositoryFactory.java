package com.devwiki.backend.file.business;

import com.devwiki.backend.file.model.StorageType;
import com.devwiki.backend.file.port.out.FileLocalRepository;
import com.devwiki.backend.file.port.out.FileRepository;
import com.devwiki.backend.file.port.out.FileS3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FileRepositoryFactory {

    private final FileLocalRepository fileLocalRepository;
    private final FileS3Repository fileS3Repository;

    public FileRepository create(StorageType storageType){
        return switch (storageType) {
            case LOCAL -> fileLocalRepository;
            case s3 -> fileS3Repository;
        };
    }

}
