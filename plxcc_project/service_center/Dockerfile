FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service_center.jar service_center.jar
ENTRYPOINT ["java","-jar","/service_center.jar", "&"]