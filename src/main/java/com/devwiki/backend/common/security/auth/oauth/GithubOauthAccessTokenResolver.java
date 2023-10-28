package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.auth.oauth.adapter.out.GithubApi;
import com.devwiki.backend.auth.oauth.adapter.out.GithubAuthorizationApi;
import com.devwiki.backend.auth.oauth.adapter.out.model.GithubAuthorization;
import com.devwiki.backend.auth.oauth.adapter.out.model.GithubUserInfo;
import com.devwiki.backend.common.security.auth.oauth.model.OauthGithubProperties;
import com.devwiki.backend.common.security.auth.oauth.model.OauthInfo;
import com.devwiki.backend.common.security.auth.oauth.model.OauthType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GithubOauthAccessTokenResolver implements OauthAccessTokenResolver {
    private final OauthGithubProperties properties;
    private final GithubAuthorizationApi authorizationApi;
    private final GithubApi githubApi;

    @Override
    public OauthInfo resolve(String authorizationCode) {
        GithubAuthorization githubAuthorization = authorizationApi.authorizationOauth(
                properties.getClientId(),
                properties.getClientSecret(),
                authorizationCode
        );

        GithubUserInfo githubUserInfo = githubApi.fetchUserInfo(githubAuthorization.accessToken());
        return OauthInfo.from(githubUserInfo);
    }

    @Override
    public boolean supports(OauthType type) {
        return type.equals(OauthType.GITHUB);
    }
}
