
# 도커 이미지의 기반이 될 이미지를 지정합니다.
FROM docker.elastic.co/elasticsearch/elasticsearch:8.11.0

# Elasticsearch의 환경 변수를 설정합니다.
ENV discovery.type=single-node
ENV xpack.security.enabled=false
ENV xpack.security.enrollment.enabled=false
ENV xpack.security.http.ssl.enabled=false
ENV xpack.security.transport.ssl.enabled=false
ENV ES_JAVA_OPTS="-Xms512m -Xmx512m"

# 도커 이미지 빌드 시에 실행되는 명령을 추가할 수 있습니다.
# 여기서는 특별한 명령을 실행하지 않고 이미지를 기본 설정으로 사용합니다.

# 호스트 머신에서 9200 포트를 사용하여 Elasticsearch에 접속할 수 있도록 포트를 노출합니다.
EXPOSE 9200
