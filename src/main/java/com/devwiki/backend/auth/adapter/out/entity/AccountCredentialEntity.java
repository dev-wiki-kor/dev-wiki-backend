package com.devwiki.backend.auth.adapter.out.entity;

import com.devwiki.backend.auth.domain.AccountType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Table(name = "account_credential")
@NoArgsConstructor
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
}
