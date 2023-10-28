package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountEntity;
import com.devwiki.backend.auth.domain.Account;

public class AccountMapper {

    public static AccountEntity toEntity(Account account){
        return new AccountEntity(
                account.getEmail(),
                account.getNickname()
        );
    }
}
