package com.devwiki.backend.account.adapter.out.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.devwiki.backend.account.adapter.out.github.dto.GithubUserInfoResponse;

@FeignClient(name = "githubUserInfoClient", url = "https://api.github.com", configuration = {GithubRequestHeader.class})
public interface GithubUserInfoFeign {

	@GetMapping("/user")
	GithubUserInfoResponse getUserInfo(@RequestHeader("Authorization") String accessToken);

}
