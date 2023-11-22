package com.devwiki.backend.account.adapter.out.github;

import static org.junit.jupiter.api.Assertions.*;
import com.devwiki.backend.account.adapter.out.github.dto.GithubLoginSucessResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeignClientTest {

    private final String GITHUB_ACCESS_CODE = "47cf227cc7e630581f71";
    private static final String GITHUB_SECRET = "8dca729660542f8a7038a0f234a231d4e7fa94aa";
    private static final String GITHUB_CLIENT_ID = "c762b77b5518e2e55544";
    @Autowired
    GithubAccessTokenFeign githubAccessTokenFeign;



    @Test
    void 페인_클라이언트_테스트_비활성화된_코드_넣었을때_null(){
        GithubLoginSucessResponse loginSuccessInfo = githubAccessTokenFeign.requireAccessToken(
                null,
                GITHUB_CLIENT_ID,
                GITHUB_SECRET,
                GITHUB_ACCESS_CODE
        );
        assertNull(loginSuccessInfo.accessToken());
        assertNull(loginSuccessInfo.tokenType());
        assertNull(loginSuccessInfo.scope());
    }


}
