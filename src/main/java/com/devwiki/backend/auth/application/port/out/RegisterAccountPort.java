package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.Account;

public interface RegisterAccountPort {
    long register(Account account);
}
