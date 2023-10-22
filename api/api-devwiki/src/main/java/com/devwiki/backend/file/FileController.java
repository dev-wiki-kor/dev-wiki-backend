package com.devwiki.backend.file;

import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.model.StorageType;
import com.devwiki.backend.file.port.in.FileDeleteUseCase;
import com.devwiki.backend.file.port.in.FileStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/file")
@RestController
public class FileController {
    private final FileHolderResolver fileHolderResolver;
    private final FileStoreUseCase fileStoreUseCase;
    private final FileDeleteUseCase fileDeleteUseCase;

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadFile(@RequestParam MultipartFile file) {
        StorageType storageType = StorageType.LOCAL;
        FileHolder fileHolder = fileHolderResolver.resolve(file, storageType);

        fileStoreUseCase.storeFile(storageType, fileHolder);

        return fileHolder.fileUrl();

    }

    @DeleteMapping
    public void deleteFile(@RequestParam String fileUrl){
        fileDeleteUseCase.deleteFile(fileUrl);

    }
}
