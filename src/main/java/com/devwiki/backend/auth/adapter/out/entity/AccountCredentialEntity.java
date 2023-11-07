package com.devwiki.backend.auth.adapter.out.entity;

import com.devwiki.backend.auth.domain.AccountType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "account_credential")
@NoArgsConstructor
@Getter
@Entity
public class AccountCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_credential_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    private String secret;

    public AccountCredentialEntity(AccountType type, AccountEntity account, String secret) {
        this.accountType = type;
        this.account = account;
        this.secret = secret;
    }

    public static AccountCredentialEntity of(AccountType type, AccountEntity account, String secret){
        return new AccountCredentialEntity(
                type,
                account,
                secret
        );
    }
}
