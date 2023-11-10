package com.devwiki.backend.auth.adapter.in;

import com.devwiki.backend.auth.oauth.adapter.out.GithubAuthorizationApi;
import com.devwiki.backend.auth.oauth.adapter.out.model.GithubAuthorization;
import com.devwiki.backend.auth.oauth.adapter.out.model.OauthGithubProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthController {

    private final OauthGithubProperties properties;
    private final GithubAuthorizationApi githubAuthorizationApi;

    @GetMapping("/callback")
    public ResponseEntity<String> getUserInfo(@RequestParam String code){
        String accessToken =
                githubAuthorizationApi.authorizationOauth(
                        properties.getClientId(),
                        properties.getClientSecret(),
                        code
                ).accessToken();


    }


}
