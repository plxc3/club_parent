FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/acm_admin.jar acm_admin.jar
ENTRYPOINT ["java","-jar","/acm_admin.jar", "&"]