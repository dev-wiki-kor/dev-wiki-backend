package com.devwiki.backend.auth.adapter.out.entity;

import com.devwiki.backend.auth.domain.AccountRole;
import com.devwiki.backend.common.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "account")
@Entity
public class AccountEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String email;

    private String nickname;

    private String profileImageUrl;

    private String pageUrl;

    @Enumerated(value = EnumType.STRING)
    private AccountRole role;

    public AccountEntity(String email, String nickname, String profileImageUrl, String pageUrl, AccountRole role) {
        this.email = email;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.pageUrl = pageUrl;
        this.role = role;
    }

    public static AccountEntity of(String email, String nickname, String profileImageUrl, String pageUrl, AccountRole role) {
        return new AccountEntity(
                email,
                nickname,
                profileImageUrl,
                pageUrl,
                role
        );
    }
}
