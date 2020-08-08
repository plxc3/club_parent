FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/gateway_service.jar gateway_service.jar
ENTRYPOINT ["java","-jar","/gateway_service.jar", "&"]