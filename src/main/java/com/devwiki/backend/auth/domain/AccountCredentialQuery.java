package com.devwiki.backend.auth.domain;

public record AccountCredentialQuery(
        Long accountId,
        AccountType accountType,
        String secret
) {
}
