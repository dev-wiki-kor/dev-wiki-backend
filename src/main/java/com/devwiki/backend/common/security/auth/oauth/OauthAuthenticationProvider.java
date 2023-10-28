package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.auth.application.port.out.QueryAccountCredentialPort;
import com.devwiki.backend.auth.application.port.out.RegisterAccountPort;
import com.devwiki.backend.auth.domain.*;
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
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OauthAuthenticationProvider implements AuthenticationProvider {
    private final OauthAccessTokenResolverFactory factory;
    private final QueryAccountCredentialPort queryAccountCredentialPort;
    private final RegisterAccountPort registerAccountPort;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OauthAuthenticateToken oauthAuthenticateToken = (OauthAuthenticateToken) authentication;
        OauthAccessTokenResolver resolver = factory.getResolver(oauthAuthenticateToken.getOauthType());
        OauthInfo oauthInfo = resolver.resolve(oauthAuthenticateToken.getAuthorizationCode());

        AccountCredentialQueryCondition queryCondition = new AccountCredentialQueryCondition(
                AccountType.SOCIAL,
                oauthInfo.uniqueId()
        );
        Optional<AccountCredential> accountCredential = queryAccountCredentialPort.query(queryCondition);
        Account account;

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (accountCredential.isEmpty()) {
            account = Account.builder()
                    .email(oauthInfo.email())
                    .nickname(oauthInfo.nickname())
                    .profileImageUrl(oauthInfo.profileUrl())
                    .pageUrl(oauthInfo.pageUrl())
                    .accountRole(AccountRole.USER)
                    .build();

            registerAccountPort.register(account);
        } else {
            account = accountCredential.get()
                    .getAccount();
        }

        grantedAuthorities.add(new SimpleGrantedAuthority(account.getAccountRole().name()));

        return new UsernamePasswordAuthenticationToken(
                oauthInfo.nickname(), oauthInfo.uniqueId(), grantedAuthorities
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OauthAuthenticateToken.class.isAssignableFrom(authentication);
    }
}
