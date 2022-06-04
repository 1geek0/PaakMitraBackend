FROM --platform=linux/amd64 openjdk:18-alpine
MAINTAINER 1geek0

WORKDIR app
COPY build/libs/paak_mitra_api-0.0.1-SNAPSHOT.jar ./paak_mitra_api-0.0.1.jar

COPY .env .env

ENTRYPOINT ["java", "-jar", "/app/paak_mitra_api-0.0.1.jar"]