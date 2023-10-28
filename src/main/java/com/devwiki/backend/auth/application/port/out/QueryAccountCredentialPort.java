package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.AccountCredential;
import com.devwiki.backend.auth.domain.AccountCredentialQueryCondition;

import java.util.Optional;

public interface QueryAccountCredentialPort {
    Optional<AccountCredential> query(AccountCredentialQueryCondition queryCondition);
}
