package com.devwiki.backend.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class Account {
    private Long id;

    private String nickname;

    private String email;

    private String profileImageUrl;

    private String pageUrl;

    private AccountRole accountRole;

    public Account(String nickname, String email, String profileImageUrl, String pageUrl, AccountRole accountRole) {
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.pageUrl = pageUrl;
        this.accountRole = accountRole;
    }

    public static Account of(String nickname, String email, String profileImageUrl, String pageUrl, AccountRole accountRole) {
        return new Account(
                nickname,
                email,
                profileImageUrl,
                pageUrl,
                accountRole
        );
    }
}
