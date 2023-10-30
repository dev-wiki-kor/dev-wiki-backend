package com.devwiki.backend.auth.application.service;

import com.devwiki.backend.auth.application.port.in.RegisterAccountUseCase;
import com.devwiki.backend.auth.application.port.out.RegisterAccountPort;
import com.devwiki.backend.auth.domain.AccountCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RegisterAccountService implements RegisterAccountUseCase {
    private final RegisterAccountPort registerAccountPort;


    @Override
    @Transactional
    public long register(AccountCredential accountCredential) {
        validation(accountCredential);
        return registerAccountPort.register(accountCredential);
    }

    private void validation(AccountCredential accountCredential){
        //TODO Validation 로직 작성
    }
}
