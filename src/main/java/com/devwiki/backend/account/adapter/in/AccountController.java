package com.devwiki.backend.account.adapter.in;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.account.adapter.in.dto.LoginSuccessDto;
import com.devwiki.backend.feignClient.github.GithubAccessTokenFeign;
import com.devwiki.backend.feignClient.github.GithubUserInfoFeign;
import com.devwiki.backend.feignClient.github.dto.GithubLoginSucessResponse;
import com.devwiki.backend.feignClient.github.dto.GithubUserInfoResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

	private final GithubAccessTokenFeign githubAccessTokenFeign;

	private final GithubUserInfoFeign githubUserInfoFeign;

	private static final String GITHUB_SECRET = "8dca729660542f8a7038a0f234a231d4e7fa94aa";
	private static final String GITHUB_CLIENT_ID = "c762b77b5518e2e55544";

	@RequestMapping("/github/handleLogin")
	public LoginSuccessDto handleGithubLogin(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpMethod httpMethod,
		Locale locale, // 언어 정보
		@RequestHeader MultiValueMap<String, String> headerMap,
		@RequestHeader("host") String host,
		@CookieValue(value = "myCookie", required = false) String cookie,
		@RequestParam String code
	) {
		// 1. 요청 정보 출력 ( 로그인 구현 시 참고용, 다 만든 후 제거 . )
		log.info("\n********************* handle GITHUB LOGIN ********************* ");
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("locale={}", locale);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", cookie);

		log.info("\n********************* CALL GITHUB API : ACCESS_TOKEN ********************* ");

		// 2. github login 수행
		GithubLoginSucessResponse loginSuccessInfo = githubAccessTokenFeign.requireAccessToken(
			cookie,
			GITHUB_CLIENT_ID,
			GITHUB_SECRET,
			code
		);

		// 요청 응답 출력
		log.info("loginResponse : {} ", loginSuccessInfo.toString());
		log.info("\n********************* CALL GITHUB API : USER INFO  ********************* ");

		// 3. github 유저 정보 반환 .
		GithubUserInfoResponse res = githubUserInfoFeign.getUserInfo(loginSuccessInfo.getBearerToken());
		log.info(res.toString());

		return new LoginSuccessDto(loginSuccessInfo.accessToken(), res.uniqueId());
	}
}
