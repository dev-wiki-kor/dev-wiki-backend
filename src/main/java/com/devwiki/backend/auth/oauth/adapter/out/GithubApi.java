package com.devwiki.backend.auth.oauth.adapter.out;


import com.devwiki.backend.auth.oauth.adapter.out.model.GithubUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value= "githubApi", url = "https://api.github.com")
public interface GithubApi {

    @GetMapping("/user")
    GithubUserInfo fetchUserInfo(@RequestHeader("Authorization") String authorizationHeader);
}
