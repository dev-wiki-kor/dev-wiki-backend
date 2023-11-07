package com.devwiki.backend.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class AccountCredential {
    private AccountType accountType;

    private String secret;

    private Account account;
}
