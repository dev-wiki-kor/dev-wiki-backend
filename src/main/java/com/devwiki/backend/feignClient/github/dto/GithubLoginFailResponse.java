package com.devwiki.backend.feignClient.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubLoginFailResponse(
	@JsonProperty("error") String error,
	@JsonProperty("error_description") String errorDescription,
	@JsonProperty("error_uri") String errorUri

) {
}
