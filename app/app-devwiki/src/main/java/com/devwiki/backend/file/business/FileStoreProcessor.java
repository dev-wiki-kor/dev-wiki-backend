package com.devwiki.backend.file.business;

import com.devwiki.backend.file.model.FileMetadata;
import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.model.StorageType;
import com.devwiki.backend.file.port.in.FileStoreUseCase;
import com.devwiki.backend.file.port.out.FileMetaDataRepository;
import com.devwiki.backend.file.port.out.FileRepository;
import com.devwiki.backend.file.validator.FileValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileStoreProcessor implements FileStoreUseCase {
    private final FileValidator fileValidator;

    private final FileRepositoryFactory fileRepositoryFactory;
    private final FileMetaDataRepository fileMetaDataRepository;

    /**
     * 파일 저장
     *
     * @param type       : StorageType
     * @param fileHolder : FileHolder
     */
    @Transactional
    public void storeFile(StorageType type, FileHolder fileHolder) {
        if (type.equals(StorageType.LOCAL)) {
            fileValidator.validateLocalStorageFile(fileHolder);
        }

        FileRepository fileRepository = fileRepositoryFactory.create(type);

        fileRepository.store(fileHolder);
        saveFileMetaData(type, fileHolder);

    }

    private void saveFileMetaData(StorageType type, FileHolder holder) {
        FileMetadata fileMetadata = new FileMetadata(null, type, holder.fileName(), holder.fileUrl(), holder.fileSize());
        fileMetaDataRepository.save(fileMetadata);

    }

}
