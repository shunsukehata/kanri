# ビルドステージ
FROM maven:3.8.4-jdk-11 AS builder
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package -DskipTests

# 実行ステージ
FROM openjdk:11.0.14.1-oracle
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/kanri.jar /app/kanri.jar
ENTRYPOINT ["java", "-jar", "/app/kanri.jar"]