package com.devwiki.backend.file.validator;

import com.devwiki.backend.file.exception.FileProcessorException;
import com.devwiki.backend.file.model.FileHolder;
import org.springframework.stereotype.Component;



@Component
public class FileValidator {
    public void validateLocalStorageFile(FileHolder holder) {
        String fileName = holder.fileName();

        if (fileName.contains("..")) {
            throw new FileProcessorException(FileProcessorException.OUTSIDE_STORE, fileName);
        }
    }
}
