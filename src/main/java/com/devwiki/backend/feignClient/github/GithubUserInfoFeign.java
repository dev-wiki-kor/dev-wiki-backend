package com.devwiki.backend.feignClient.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.devwiki.backend.feignClient.github.dto.GithubUserInfoResponse;

@FeignClient(name = "githubUserInfoClient", url = "https://api.github.com", configuration = {GithubRequestHeader.class})
public interface GithubUserInfoFeign {

	@GetMapping("/user")
	GithubUserInfoResponse getUserInfo(@RequestHeader("Authorization") String accessToken);

}
