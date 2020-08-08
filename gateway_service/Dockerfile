FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service.jar service.jar
ENTRYPOINT ["java","-jar","/service.jar", "&"]