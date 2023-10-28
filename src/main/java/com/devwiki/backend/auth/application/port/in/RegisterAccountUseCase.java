package com.devwiki.backend.auth.application.port.in;

import com.devwiki.backend.auth.domain.Account;

public interface RegisterAccountUseCase {
    long register(Account account);
}
