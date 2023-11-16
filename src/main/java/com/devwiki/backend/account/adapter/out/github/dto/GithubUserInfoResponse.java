package com.devwiki.backend.account.adapter.out.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubUserInfoResponse(
	String email,
	@JsonProperty("id")
	String uniqueId,
	@JsonProperty("login")
	String nickname,

	@JsonProperty("avatar_url")
	String profileUrl,

	@JsonProperty("html_url")
	String pageUrl
) {
}
