package com.devwiki.backend.common.security.auth.oauth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "oauth.github")
public class OauthGithubProperties {
    private String clientId;
    private String clientSecret;
}
