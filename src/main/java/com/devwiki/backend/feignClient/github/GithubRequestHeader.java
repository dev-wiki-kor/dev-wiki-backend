package com.devwiki.backend.feignClient.github;

import feign.RequestInterceptor;

public class GithubRequestHeader {
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			requestTemplate.header("Content-Type", "application/json");
			requestTemplate.header("Accept", "application/json");
			requestTemplate.header("User-Agent", "dev_wiki/1.0_snapshot");
		};
	}
}
