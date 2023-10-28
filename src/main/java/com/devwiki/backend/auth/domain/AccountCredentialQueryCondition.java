package com.devwiki.backend.auth.domain;

public record AccountCredentialQueryCondition(
        AccountType accountType,
        String secret
) {
}
