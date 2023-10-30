package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountCredentialEntity;
import com.devwiki.backend.auth.domain.AccountType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountCredentialJpaRepository extends JpaRepository<AccountCredentialEntity, Long> {
    @Query("SELECT a " +
            "FROM AccountCredentialEntity a " +
            "WHERE a.accountType = :accountType " +
            "AND a.secret = :secret"
    )
    @EntityGraph(attributePaths = {"account"})
    Optional<AccountCredentialEntity> query(
            @Param("accountType") AccountType accountType,
            @Param("secret") String secret
    );
}
