FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service_dao.jar service_dao.jar
ENTRYPOINT ["java","-jar","/service_dao.jar", "&"]
