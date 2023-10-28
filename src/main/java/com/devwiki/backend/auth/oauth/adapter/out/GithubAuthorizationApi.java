package com.devwiki.backend.auth.oauth.adapter.out;

import com.devwiki.backend.auth.oauth.adapter.out.model.GithubAuthorization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value= "oauthGithubApi", url = "https://github.com")
public interface GithubAuthorizationApi {

    @PostMapping(value = "/login/oauth/access_token", produces = MediaType.APPLICATION_JSON_VALUE)
    GithubAuthorization authorizationOauth(
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("code") String code
    );
}
