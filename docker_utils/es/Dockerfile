
# 벡터 검색 지원때문에 8버전 설치
FROM docker.elastic.co/elasticsearch/elasticsearch:8.11.0

# Elasticsearch의 환경 변수 -> 환경변수로만 해도 elasticseasrch.yml 에 반영
ENV discovery.type=single-node

# localhost 보안 없이 로그인 하는데 필요
ENV xpack.security.enabled=false
ENV xpack.security.enrollment.enabled=false
ENV xpack.security.http.ssl.enabled=false
ENV xpack.security.transport.ssl.enabled=false

# 1GB 넘으면 부트 오래걸려서 .... 이건 컴 좋으면 더 늘려도 okay
ENV ES_JAVA_OPTS="-Xms512m -Xmx512m"


EXPOSE 9200

# nori 쓸것임
RUN elasticsearch-plugin install analysis-nori
