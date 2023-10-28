package com.devwiki.backend.auth.adapter.out.entity;

import com.devwiki.backend.common.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

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

    public AccountEntity(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
