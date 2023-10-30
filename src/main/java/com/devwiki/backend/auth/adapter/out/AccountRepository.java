package com.devwiki.backend.auth.adapter.out;

import com.devwiki.backend.auth.adapter.out.entity.AccountCredentialEntity;
import com.devwiki.backend.auth.adapter.out.entity.AccountEntity;
import com.devwiki.backend.auth.application.port.out.QueryAccountCredentialPort;
import com.devwiki.backend.auth.application.port.out.QueryAccountPort;
import com.devwiki.backend.auth.application.port.out.RegisterAccountPort;
import com.devwiki.backend.auth.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AccountRepository implements RegisterAccountPort, QueryAccountCredentialPort, QueryAccountPort  {

    private final AccountCredentialJpaRepository accountCredentialJpaRepository;
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public long register(AccountCredential accountCredential) {
        AccountEntity accountEntity = AccountMapper.toEntity(accountCredential.getAccount());
        accountJpaRepository.save(accountEntity);

        AccountCredentialEntity accountCredentialEntity = AccountMapper.toEntity(accountCredential, accountEntity);
        accountCredentialJpaRepository.save(accountCredentialEntity);

        return accountEntity.getId();
    }
    @Override
    public Optional<AccountCredential> query(AccountType accountType, String secret) {
        return accountCredentialJpaRepository.query(accountType, secret)
                .map(AccountMapper::toDomain);
    }


    @Override
    public Optional<Account> query(Long id) {
        return accountJpaRepository.findById(id)
                .map(AccountMapper::toDomain);
    }
}
