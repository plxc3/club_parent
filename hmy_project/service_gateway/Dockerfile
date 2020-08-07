FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service_gateway.jar service_gateway.jar
ENTRYPOINT ["java","-jar","/service_gateway.jar", "&"]
