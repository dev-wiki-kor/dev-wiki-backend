package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.AccountCredential;

public interface RegisterAccountPort {
    long register(AccountCredential accountCredential);
}
