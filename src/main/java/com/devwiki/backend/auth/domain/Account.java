package com.devwiki.backend.auth.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Account {
    private Long id;

    private String nickname;

    private String email;

    private String profileImageUrl;

    private String pageUrl;

    private AccountRole accountRole;

    @Builder
    public Account(Long id,String nickname, String email, String profileImageUrl, String pageUrl, AccountRole accountRole) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.pageUrl = pageUrl;
        this.accountRole = accountRole;
    }
}
