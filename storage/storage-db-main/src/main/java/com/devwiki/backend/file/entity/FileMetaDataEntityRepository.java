package com.devwiki.backend.file.entity;

import com.devwiki.backend.file.business.model.FileMetadata;
import com.devwiki.backend.file.port.out.FileMetaDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FileMetaDataEntityRepository implements FileMetaDataRepository {

    private final FileMetaDataJpaRepository fileMetaDataJpaRepository;
    private final FileMapper fileMapper;

    @Override
    public Optional<FileMetadata> findByUrl(String fileUrl) {
        return fileMetaDataJpaRepository.findByUrl(fileUrl)
                .map(fileMapper::toDomain);
    }

    @Override
    public void delete(FileMetadata fileMetadata) {
        FileMetadataEntity entity = fileMapper.toEntity(fileMetadata);
        fileMetaDataJpaRepository.delete(entity);
    }

    @Override
    public void save(FileMetadata fileMetadata) {
        FileMetadataEntity entity = fileMapper.toEntity(fileMetadata);
        fileMetaDataJpaRepository.save(entity);
    }
}
