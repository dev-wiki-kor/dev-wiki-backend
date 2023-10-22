package com.devwiki.backend.file.validator;

import com.devwiki.backend.file.model.FileHolder;
import org.springframework.stereotype.Component;



@Component
public class FileValidator {
    public boolean isOutSideFolderStore(FileHolder holder) {
        String fileName = holder.fileName();

        return fileName.contains("..");
    }
}
