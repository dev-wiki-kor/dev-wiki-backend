package com.devwiki.backend.auth.application.port.in;

import com.devwiki.backend.auth.domain.AccountCredential;

public interface RegisterAccountUseCase {
    long register(AccountCredential accountCredential);
}
