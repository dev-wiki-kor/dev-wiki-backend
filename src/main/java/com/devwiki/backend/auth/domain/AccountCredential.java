package com.devwiki.backend.auth.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountCredential {
    private AccountType accountType;

    private String secret;

    private Account account;

    @Builder
    public AccountCredential(AccountType type, String secret, Account account){
        this.accountType = type;
        this.secret = secret;
        this.account = account;
    }
}
