package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.auth.application.port.in.LoginUseCase;
import com.devwiki.backend.auth.domain.Account;
import com.devwiki.backend.auth.domain.AccountCredential;
import com.devwiki.backend.auth.domain.AccountRole;
import com.devwiki.backend.common.security.auth.oauth.model.OauthAuthenticateToken;
import com.devwiki.backend.common.security.auth.oauth.model.OauthInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OauthAuthenticationProvider implements AuthenticationProvider {
    private final OauthAccessTokenResolverFactory factory;
    private final LoginUseCase loginUseCase;

    private final static String ROLE_PREFIX = "ROLE_";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OauthAuthenticateToken oauthAuthenticateToken = (OauthAuthenticateToken) authentication;
        OauthAccessTokenResolver resolver = factory.getResolver(oauthAuthenticateToken.getOauthType());
        OauthInfo oauthInfo = resolver.resolve(oauthAuthenticateToken.getAuthorizationCode());

        AccountCredential accountCredential = loginUseCase.socialLogin(oauthInfo);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Account account = accountCredential.getAccount();
        grantedAuthorities.add(convertAuthority(account.getAccountRole()));

        return new UsernamePasswordAuthenticationToken(
                account.getId(), accountCredential.getSecret(), grantedAuthorities
        );
    }

    private GrantedAuthority convertAuthority(AccountRole role) {
        return new SimpleGrantedAuthority(ROLE_PREFIX + role.name());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OauthAuthenticateToken.class.isAssignableFrom(authentication);
    }
}
