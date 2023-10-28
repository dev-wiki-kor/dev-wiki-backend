package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.common.security.auth.oauth.model.OauthAuthenticateToken;
import com.devwiki.backend.common.security.auth.oauth.model.OauthType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Arrays;

public class OauthAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final String MATCH_URL_PREFIX = "/login/oauth/";

    public OauthAuthenticationFilter(AuthenticationSuccessHandler authenticationSuccessHandler,
                                     AuthenticationProvider... authenticationProvider) {
        super(new AntPathRequestMatcher(MATCH_URL_PREFIX + "*"));
        this.setAuthenticationManager(new ProviderManager(authenticationProvider));
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        OauthType oauthType = extractOauthServerType(request);
        String authorizationCode = extractAuthorizationCode(request);
        return getAuthenticationManager().authenticate(new OauthAuthenticateToken(authorizationCode, oauthType));
    }

    public String extractAuthorizationCode(HttpServletRequest request) {
        String authorizationCode = request.getHeader("Authorization");
        if (authorizationCode == null)
            throw new AuthenticationServiceException("Authentication Code가 존재하지 않습니다.");
        return authorizationCode;
    }

    public OauthType extractOauthServerType(HttpServletRequest request) {
        String extractType = request.getRequestURI().substring(MATCH_URL_PREFIX.length());
        return Arrays.stream(OauthType.values())
                .filter(type -> type.name().equalsIgnoreCase(extractType))
                .findFirst()
                .orElseThrow(() -> new AuthenticationServiceException("지원하지 않는 Oauth Type 입니다."));
    }
}
