package com.devwiki.backend.account.adapter.out.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubLoginFailResponse(
	@JsonProperty("error") String error,
	@JsonProperty("error_description") String errorDescription,
	@JsonProperty("error_uri") String errorUri

) {
}
