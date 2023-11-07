package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.AccountCredential;
import com.devwiki.backend.auth.domain.AccountType;

import java.util.Optional;

public interface QueryAccountCredentialPort {
    Optional<AccountCredential> query(AccountType accountType, String secret);
}
