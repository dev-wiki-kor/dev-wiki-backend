package com.devwiki.backend.file.business;

import com.devwiki.backend.file.exception.FileInvalidException;
import com.devwiki.backend.file.model.FileMetadata;
import com.devwiki.backend.file.port.in.FileDeleteUseCase;
import com.devwiki.backend.file.port.out.FileMetaDataRepository;
import com.devwiki.backend.file.port.out.FileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class FileDeleteProcessor implements FileDeleteUseCase {
    private final FileRepositoryFactory fileRepositoryFactory;
    private final FileMetaDataRepository metaDataRepository;

    /**
     * 파일 삭제
     *
     * @param fileUrl : FileUrl
     */
    @Transactional
    public void deleteFile(String fileUrl) {
        FileMetadata fileMetadata = metaDataRepository.findByUrl(fileUrl)
                .orElseThrow(() -> new FileProcessorException(FileProcessorException.DELETE, fileUrl));

        FileRepository fileRepository = fileRepositoryFactory.create(fileMetadata.storageType());

        fileRepository.delete(fileMetadata.filename());
        metaDataRepository.delete(fileMetadata);
    }

}
