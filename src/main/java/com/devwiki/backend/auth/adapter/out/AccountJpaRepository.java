package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
}
