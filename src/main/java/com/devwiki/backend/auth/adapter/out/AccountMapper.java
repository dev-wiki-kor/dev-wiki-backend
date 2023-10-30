package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountCredentialEntity;
import com.devwiki.backend.auth.adapter.out.entity.AccountEntity;
import com.devwiki.backend.auth.domain.Account;
import com.devwiki.backend.auth.domain.AccountCredential;

public class AccountMapper {

    public static AccountEntity toEntity(Account account) {
        return AccountEntity.builder()
                .email(account.getEmail())
                .nickname(account.getNickname())
                .profileImageUrl(account.getProfileImageUrl())
                .pageUrl(account.getPageUrl())
                .role(account.getAccountRole())
                .build();
    }

    public static Account toDomain(AccountEntity account) {
        return Account.builder()
                .id(account.getId())
                .email(account.getEmail())
                .nickname(account.getNickname())
                .profileImageUrl(account.getProfileImageUrl())
                .pageUrl(account.getPageUrl())
                .accountRole(account.getRole())
                .build();
    }

    public static AccountCredential toDomain(AccountCredentialEntity accountCredential) {
        return AccountCredential.builder()
                .type(accountCredential.getAccountType())
                .secret(accountCredential.getSecret())
                .account(toDomain(accountCredential.getAccount()))
                .build();
    }

    public static AccountCredentialEntity toEntity(AccountCredential accountCredential, AccountEntity account) {
        return AccountCredentialEntity.builder()
                .type(accountCredential.getAccountType())
                .account(account)
                .secret(accountCredential.getSecret())
                .build();
    }
}
