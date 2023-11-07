package com.devwiki.backend.auth.application.service;

import com.devwiki.backend.auth.application.port.in.LoginUseCase;
import com.devwiki.backend.auth.application.port.out.QueryAccountCredentialPort;
import com.devwiki.backend.auth.domain.Account;
import com.devwiki.backend.auth.domain.AccountCredential;
import com.devwiki.backend.auth.domain.AccountRole;
import com.devwiki.backend.auth.domain.AccountType;
import com.devwiki.backend.common.security.auth.oauth.model.OauthInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {
    private final QueryAccountCredentialPort queryAccountCredentialPort;
    private final RegisterAccountService registerAccountService;

    @Override
    public AccountCredential login(Long accountId, String secret) {
        return null;
    }

    @Override
    public AccountCredential socialLogin(OauthInfo oauthInfo) {
        return queryAccountCredentialPort.query(AccountType.SOCIAL, oauthInfo.uniqueId())
                .orElseGet(() -> {
                    Account account = Account.of(
                            oauthInfo.email(),
                            oauthInfo.nickname(),
                            oauthInfo.profileUrl(),
                            oauthInfo.pageUrl(),
                            AccountRole.USER
                    );

                    AccountCredential accountCredential = AccountCredential.of(
                            AccountType.SOCIAL,
                            oauthInfo.uniqueId(),
                            account
                    );

                    registerAccountService.register(accountCredential);
                    return accountCredential;
                });
    }
}
