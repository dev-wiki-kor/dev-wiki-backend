#!/bin/bash

echo "BUILD REDIS IMAGE"
docker build -t my-custom-redis-image .

echo "RUN REDIS IMAGE"
docker run -d --name my-redis-container -p 6379:6379 my-custom-redis-image