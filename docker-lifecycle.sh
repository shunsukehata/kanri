#!/bin/bash

# docker-compose.yml のフルパスを指定（例: プロジェクトルートディレクトリに配置されている場合）
DOCKER_COMPOSE_PATH="./compose.yaml"

case "$1" in
  start)
    echo "既存のMySQLコンテナを停止しています..."
    docker-compose -f $DOCKER_COMPOSE_PATH down
    echo "docker-composeでMySQLコンテナを起動しています..."
    docker-compose -f $DOCKER_COMPOSE_PATH up -d
    echo "MySQLの準備が整うのを待っています..."
    for i in {1..60}; do  # 待機時間を延長
      if docker-compose -f $DOCKER_COMPOSE_PATH exec kanri_mysql mysql -ushunuser -pmysql0710 -e 'select 1'; then
        echo "MySQLの準備が整いました！"
        exit 0
      fi
      echo "MySQLの準備を待っています... ($i)"
      sleep 2
    done
    echo "タイムアウト期間内にMySQLが起動しませんでした。"
    exit 1
    ;;
  stop)
    echo "docker-composeでMySQLコンテナを停止しています..."
    docker-compose -f $DOCKER_COMPOSE_PATH down
    echo "MySQLコンテナが停止しました。"
    ;;
  build)
    echo "docker-composeでMySQLコンテナをビルドしています..."
    docker-compose -f $DOCKER_COMPOSE_PATH build
    ;;
  *)
    echo "Usage: $0 {start|stop|build}"
    exit 1
    ;;
esac