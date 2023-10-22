package com.devwiki.backend.file.business;

import com.devwiki.backend.file.exception.FileInvalidException;
import com.devwiki.backend.file.model.StorageType;
import com.devwiki.backend.file.port.in.FileLoadUseCase;
import com.devwiki.backend.file.port.out.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;


@RequiredArgsConstructor
@Service
public class FileLoadProcessor implements FileLoadUseCase {
    private final FileRepositoryFactory fileRepositoryFactory;

    /**
     * 파일 로드
     *
     * @param type     : StorageType
     * @param fileName : FileName
     * @return LoadFile
     */
    public File loadFile(StorageType type, String fileName) {
        FileRepository fileRepository = fileRepositoryFactory.create(type);
        File loadFile = fileRepository.load(fileName);

        if (isInValidFile(loadFile)) {
            throw new FileProcessorException(FileProcessorException.LOAD, fileName);
        }

        return loadFile;
    }

    private boolean isInValidFile(File file) {
        return file == null || !file.exists() || !file.canRead();
    }

}
