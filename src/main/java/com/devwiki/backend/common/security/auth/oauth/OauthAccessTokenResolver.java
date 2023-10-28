package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.common.security.auth.oauth.model.OauthInfo;
import com.devwiki.backend.common.security.auth.oauth.model.OauthType;

public interface OauthAccessTokenResolver {
    OauthInfo resolve(String authorizationCode);

    boolean supports(OauthType type);
}
