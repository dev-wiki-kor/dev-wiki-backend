package com.devwiki.backend.file.business;

import com.devwiki.backend.file.business.exception.FileProcessorException;
import com.devwiki.backend.file.model.FileHolder;
import org.springframework.stereotype.Component;

import static com.devwiki.backend.file.business.exception.FileProcessorException.OUTSIDE_STORE;


@Component
public class FileValidator {
    public void validateLocalStorageFile(FileHolder holder) {
        String fileName = holder.fileName();

        if (fileName.contains("..")) {
            throw new FileProcessorException(OUTSIDE_STORE, fileName);
        }
    }
}
