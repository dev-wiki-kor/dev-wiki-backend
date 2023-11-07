package com.devwiki.backend.common.security.auth.oauth.model;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
public class OauthAuthenticateToken extends AbstractAuthenticationToken {
    private final String authorizationCode;
    private final OauthType oauthType;
    public OauthAuthenticateToken(String authorizationCode, OauthType oauthType) {
        super(null);
        this.authorizationCode = authorizationCode;
        this.oauthType = oauthType;
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
