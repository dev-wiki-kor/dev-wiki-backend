package com.devwiki.backend.auth.oauth.adapter.out.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubUserInfo (
        String email,
        @JsonProperty("id")
        String uniqueId,
        @JsonProperty("login")
        String nickname,
        @JsonProperty("avatar_url")
        String profileUrl,

        @JsonProperty("html_url")
        String pageUrl
){
}
