# 도커파일이 있는 디렉토리로 이동합니다.

# 도커 이미지 빌드
docker build -t my-elasticsearch .

# 도커 컨테이너 실행
docker run -d -p 9200:9200 --name my-elasticsearch-container my-elasticsearch


echo "ELASTICSEARCH 8.11 DOCKER EXECUTED "