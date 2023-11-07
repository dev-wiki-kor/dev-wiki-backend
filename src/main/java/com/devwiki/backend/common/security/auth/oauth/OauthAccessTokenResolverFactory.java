package com.devwiki.backend.common.security.auth.oauth;

import com.devwiki.backend.common.security.auth.oauth.model.OauthType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OauthAccessTokenResolverFactory {
    private final List<OauthAccessTokenResolver> resolvers = new ArrayList<>();

    public OauthAccessTokenResolverFactory(OauthAccessTokenResolver... resolvers) {
        this.resolvers.addAll(List.of(resolvers));
    }

    public OauthAccessTokenResolver getResolver(OauthType type) {
        return resolvers.stream()
                .filter(resolver -> resolver.supports(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not supports OauthTokenResolver"));
    }
}
