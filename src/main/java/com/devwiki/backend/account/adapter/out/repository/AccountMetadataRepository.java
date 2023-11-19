package com.devwiki.backend.account.adapter.out.repository;

import com.devwiki.backend.account.adapter.out.entity.AccountMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMetadataRepository extends JpaRepository<AccountMetadata,Long> {
    boolean existsAccountMetadataByUniqueId(String uniqueId);
}
