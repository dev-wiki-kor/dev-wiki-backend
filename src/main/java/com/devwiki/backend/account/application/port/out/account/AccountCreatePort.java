package com.devwiki.backend.account.application.port.out.account;

import com.devwiki.backend.account.adapter.out.github.dto.GithubUserInfoResponse;

public interface AccountCreatePort {
    void createAccount(GithubUserInfoResponse githubUserInfoResponse);
}
