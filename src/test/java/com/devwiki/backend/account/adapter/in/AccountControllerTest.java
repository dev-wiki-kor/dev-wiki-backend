package com.devwiki.backend.account.adapter.in;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.devwiki.backend.account.adapter.out.github.GithubAccessTokenFeign;
import com.devwiki.backend.account.adapter.out.github.GithubUserInfoFeign;
import com.devwiki.backend.account.adapter.out.github.dto.GithubUserInfoResponse;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AccountControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountController accountController;

    @MockBean
    private GithubAccessTokenFeign githubAccessTokenFeign;

    @MockBean
    private GithubUserInfoFeign githubUserInfoFeign;

    private final String GITHUB_ACCESS_CODE = "47cf227cc7e630581f71";

    @Test
    void 깃허브_로그인_세션_등록_완료() throws Exception{
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("code",GITHUB_ACCESS_CODE);
        given(githubAccessTokenFeign.requireAccessToken(anyString(),anyString(),anyString(),anyString()))
                .willReturn(null);
        given(githubUserInfoFeign.getUserInfo(anyString()))
                .willReturn(new GithubUserInfoResponse(
                        null,
                        "83526248",
                        "lectykim",
                        "https://avatars.githubusercontent.com/u/83526248?v=4",
                        "https://github.com/lectykim"
                ));

        mockMvc.perform(post("/account/github/handleLogin").header("host","localhost:8080")
                        .params(params))
                .andDo(print());
    }



}
