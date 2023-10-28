package com.devwiki.backend.common.security.auth.oauth.model;

import com.devwiki.backend.auth.oauth.adapter.out.model.GithubUserInfo;

public record OauthInfo(
        String uniqueId,
        String email,
        String nickname,
        String profileUrl,
        String pageUrl
) {

    public static OauthInfo from(GithubUserInfo githubUserInfo) {
        return new OauthInfo(
                githubUserInfo.uniqueId(),
                githubUserInfo.email(),
                githubUserInfo.nickname(),
                githubUserInfo.profileUrl(),
                githubUserInfo.pageUrl()
        );
    }
}
