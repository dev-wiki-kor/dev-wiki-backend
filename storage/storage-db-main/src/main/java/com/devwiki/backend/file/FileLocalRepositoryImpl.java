package com.devwiki.backend.file;

import com.devwiki.backend.file.model.FileHolder;
import com.devwiki.backend.file.port.out.FileLocalRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Repository
public class FileLocalRepositoryImpl implements FileLocalRepository {

    private final Path path = Path.of(".");

    @Override
    public File load(String fileName) {
        Path filePath = path.resolve(fileName).normalize();
        return filePath.toFile();
    }

    @Override
    public void delete(String fileName) {
        try {
            Path filePath = path.resolve(fileName).normalize();
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new FileRepositoryException(FileRepositoryException.DELETE, fileName);
        }
    }

    @Override
    public void store(FileHolder fileHolder) {
        String fileName = fileHolder.fileName();
        Path filePath = path.resolve(fileName).normalize();

        try {
            Files.createDirectories(filePath.getParent());
            Files.copy(fileHolder.fileInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileRepositoryException(FileRepositoryException.STORE, fileName);
        }
    }
}
