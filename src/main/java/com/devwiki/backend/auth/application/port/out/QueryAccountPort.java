package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.Account;

import java.util.Optional;

public interface QueryAccountPort {
    Optional<Account> query(Long id);
}
