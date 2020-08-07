FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/service_club.jar service_club.jar
ENTRYPOINT ["java","-jar","/service_club.jar", "&"]
