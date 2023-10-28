package com.devwiki.backend.auth.application.service;

import com.devwiki.backend.auth.application.port.in.RegisterAccountUseCase;
import com.devwiki.backend.auth.application.port.out.RegisterAccountPort;
import com.devwiki.backend.auth.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterAccountService implements RegisterAccountUseCase {
    private final RegisterAccountPort registerAccountPort;
    @Override
    public long register(Account account) {
        return registerAccountPort.register(account);
    }

    private void validate(Account account){

    }
}
