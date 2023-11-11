package com.devwiki.backend.feignClient.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubLoginSucessResponse(
	@JsonProperty("access_token") String accessToken,
	@JsonProperty("token_type") String tokenType ,
	@JsonProperty("scope") String scope) {

	public String getBearerToken() {
		return "Bearer "+accessToken;
	}
}
