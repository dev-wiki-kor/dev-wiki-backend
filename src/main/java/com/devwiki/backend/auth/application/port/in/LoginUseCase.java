package com.devwiki.backend.auth.application.port.in;

import com.devwiki.backend.auth.domain.AccountCredential;
import com.devwiki.backend.common.security.auth.oauth.model.OauthInfo;

public interface LoginUseCase {
    AccountCredential login(Long accountId, String secret);
    AccountCredential socialLogin(OauthInfo oauthInfo);
}
