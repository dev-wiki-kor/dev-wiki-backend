package com.devwiki.backend.common.es;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class EsConfig extends ElasticsearchConfiguration {

	@Value("${es.host}")
	private String host;

	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.builder()
			.connectedTo(host)
			.build();
	}

	/*
	config 설정 api
	https://docs.spring.io/spring-data/elasticsearch/docs/current/api/org/springframework/data/elasticsearch/client/ClientConfiguration.html
	https://docs.spring.io/spring-data/elasticsearch/docs/current/api/org/springframework/data/elasticsearch/client/ClientConfiguration.MaybeSecureClientConfigurationBuilder.html
	 */
}