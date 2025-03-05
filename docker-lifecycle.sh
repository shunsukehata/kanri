#!/bin/bash

# docker-compose.yml のフルパスを指定（例: プロジェクトルートディレクトリに配置されている場合）
DOCKER_COMPOSE_PATH="./compose.yaml"

case "$1" in
  start)
    echo "Starting MySQL container with docker-compose..."
    docker-compose -f $DOCKER_COMPOSE_PATH up -d
    echo "Waiting for MySQL to be ready..."
    for i in {1..60}; do  # 待機時間を延長
      if docker-compose -f $DOCKER_COMPOSE_PATH exec kanri_mysql mysql -ushunuser -pmysql0710 -e 'select 1'; then
        echo "MySQL is ready!"
        exit 0
      fi
      echo "Waiting for MySQL... ($i)"
      sleep 2
    done
    echo "MySQL failed to start within the timeout period."
    exit 1
    ;;
  stop)
    echo "Stopping MySQL container with docker-compose..."
    docker-compose -f $DOCKER_COMPOSE_PATH down
    echo "MySQL container stopped."
    ;;
  build)
    echo "Building MySQL container with docker-compose..."
    docker-compose -f $DOCKER_COMPOSE_PATH build
    ;;
  *)
    echo "Usage: $0 {start|stop|build}"
    exit 1
    ;;
esac