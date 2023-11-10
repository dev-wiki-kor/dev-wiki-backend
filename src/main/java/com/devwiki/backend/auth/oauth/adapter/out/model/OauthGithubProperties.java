package com.devwiki.backend.auth.oauth.adapter.out.model;

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
