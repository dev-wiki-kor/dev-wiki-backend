package com.devwiki.backend.account.adapter.out.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.devwiki.backend.account.adapter.out.github.dto.GithubLoginSucessResponse;

@FeignClient(name = "githubAccessTokenClient", url = "https://github.com", configuration = {GithubRequestHeader.class})
public interface GithubAccessTokenFeign {
	@PostMapping(value = "login/oauth/access_token", produces = MediaType.APPLICATION_JSON_VALUE)
	GithubLoginSucessResponse requireAccessToken(
		@RequestHeader("Cookie") String cookie,
		@RequestParam("client_id") String clientId,
		@RequestParam("client_secret") String clientSecret,
		@RequestParam("code") String code
	);


}



