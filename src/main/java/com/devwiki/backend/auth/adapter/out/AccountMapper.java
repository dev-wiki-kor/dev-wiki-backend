package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountCredentialEntity;
import com.devwiki.backend.auth.adapter.out.entity.AccountEntity;
import com.devwiki.backend.auth.domain.Account;
import com.devwiki.backend.auth.domain.AccountCredential;

public class AccountMapper {

    public static AccountEntity toEntity(Account account) {
        return AccountEntity.of(
                account.getEmail(),
                account.getNickname(),
                account.getProfileImageUrl(),
                account.getPageUrl(),
                account.getAccountRole()
        );
    }

    public static Account toDomain(AccountEntity account) {
        return Account.of(
                account.getId(),
                account.getEmail(),
                account.getNickname(),
                account.getProfileImageUrl(),
                account.getPageUrl(),
                account.getRole()
        );
    }

    public static AccountCredential toDomain(AccountCredentialEntity accountCredential) {
        return AccountCredential.of(
                accountCredential.getAccountType(),
                accountCredential.getSecret(),
                toDomain(accountCredential.getAccount())
        );
    }

    public static AccountCredentialEntity toEntity(AccountCredential accountCredential, AccountEntity account) {
        return AccountCredentialEntity.of(
                accountCredential.getAccountType(),
                account,
                accountCredential.getSecret()
        );
    }
}
