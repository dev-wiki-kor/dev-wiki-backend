package com.devwiki.backend.auth.domain;

public record AccountQueryCondition(
        Long accountId,
        String nickname
) {
}
