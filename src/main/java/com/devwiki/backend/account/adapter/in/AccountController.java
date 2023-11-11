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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

	@RequestMapping("/github/handleLogin")
	public ResponseEntity handleGithubLogin(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpMethod httpMethod,
		Locale locale, // 언어 정보
		@RequestHeader MultiValueMap<String, String> headerMap,
		@RequestHeader("host") String host,
		@CookieValue(value = "myCookie", required = false) String cookie,
		@RequestParam String code
	){
		log.info("\n********************* handle GITHUB LOGIN ********************* ");
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("locale={}", locale);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", cookie);

		log.info("********************* CALL GITHUB API ********************* ");

		return ResponseEntity.ok("ok: " + code);
	}
}
