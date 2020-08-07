FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service_aliyun.jar service_aliyun.jar
ENTRYPOINT ["java","-jar","/service_aliyun.jar", "&"]