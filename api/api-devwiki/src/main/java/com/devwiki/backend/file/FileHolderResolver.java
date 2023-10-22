package com.devwiki.backend.file;

import com.devwiki.backend.exception.FileInvalidException;
import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.model.StorageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class FileHolderResolver {
    private final MultipartFileMetadataResolver multipartFileMetadataResolver;

    public FileHolder resolve(MultipartFile file, StorageType storageType) {

        String fileName = multipartFileMetadataResolver.resolveFileName(file);
        String fileExtension = multipartFileMetadataResolver.resolveFileExtension(file);
        String fileUrl = multipartFileMetadataResolver.resolveFileUrl(storageType, fileName);

        validateMultiPartFile(file, fileName);

        try {
            return new FileHolder(
                    file.getInputStream(),
                    fileName,
                    fileUrl,
                    file.getContentType(),
                    fileExtension,
                    file.getSize()
            );

        } catch (Exception e) {
            throw new FileInvalidException(FileInvalidException.DEFAULT, fileName);
        }

    }

    private void validateMultiPartFile(MultipartFile file, String fileName) {
        if (file == null || file.isEmpty()) {
            throw new FileInvalidException(FileInvalidException.DEFAULT, fileName);
        }
    }

}
