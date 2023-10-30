package com.devwiki.backend.auth.oauth.adapter.out.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubAuthorization(
        @JsonProperty("access_token")
        String accessToken
) {
        @Override
        public String accessToken() {
                return "Bearer "+accessToken;
        }
}
