package com.devwiki.backend.account.adapter.in.dto;

public record LoginSuccessDto(
	String accessToken,
	String uniqueGithubId
) {
}
