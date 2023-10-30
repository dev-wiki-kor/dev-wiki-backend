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
                    Account account = Account.builder()
                            .email(oauthInfo.email())
                            .nickname(oauthInfo.nickname())
                            .profileImageUrl(oauthInfo.profileUrl())
                            .pageUrl(oauthInfo.pageUrl())
                            .accountRole(AccountRole.USER)
                            .build();

                    AccountCredential accountCredential = AccountCredential.builder()
                            .account(account)
                            .secret(oauthInfo.uniqueId())
                            .type(AccountType.SOCIAL)
                            .build();

                    registerAccountService.register(accountCredential);
                    return accountCredential;
                });
    }
}
