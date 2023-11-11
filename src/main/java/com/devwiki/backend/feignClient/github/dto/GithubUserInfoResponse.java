package com.devwiki.backend.feignClient.github.dto;

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
