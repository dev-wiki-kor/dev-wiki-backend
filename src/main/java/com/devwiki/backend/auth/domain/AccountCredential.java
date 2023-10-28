package com.devwiki.backend.auth.domain;

import lombok.Getter;

@Getter
public class AccountCredential {
    private AccountType accountType;

    private String secret;

    private Account account;
}
