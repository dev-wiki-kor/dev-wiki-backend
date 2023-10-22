package com.devwiki.backend.file;

import com.devwiki.backend.file.model.StorageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.Path;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MultipartFileMetadataResolver {

    public String resolveFileName(MultipartFile file) {
        String fileName = UUID.randomUUID().toString();
        String extension = resolveFileExtension(file);

        if (StringUtils.hasText(extension)) {
            fileName += "." + extension;
        }

        String currentDate = LocalDate.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_DATE);
        String baseRoot = "local";
        return Path.of(baseRoot)
                .resolve(String.valueOf(Math.abs(currentDate.hashCode())))
                .resolve(fileName)
                .normalize().toString();
    }

    public String resolveFileExtension(MultipartFile file) {
        return StringUtils.getFilenameExtension(file.getOriginalFilename());
    }

    public String resolveFileUrl(StorageType storageType, String fileName) {
        return switch (storageType) {
            case s3 -> getS3Url(fileName);
            case LOCAL -> getLocalUrl(fileName);
        };
    }

    private String getS3Url(String fileName) {
        return UriComponentsBuilder.fromUriString("")
                .path(fileName)
                .build()
                .toUriString();
    }

    private String getLocalUrl(String fileName) {
        return "http://localhost:8080/LOCAL" + "/" + fileName;
    }

}
