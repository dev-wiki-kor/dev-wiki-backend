package com.devwiki.backend.common.security.auth.oauth.model;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties("oauth.github")
public class OauthGithubProperties {
    private String clientId;
    private String clientSecret;
}
