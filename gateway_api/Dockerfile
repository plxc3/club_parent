FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/gateway_api.jar gateway_api.jar
ENTRYPOINT ["java","-jar","/gateway_api.jar", "&"]