FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD target/login-0.0.1-SNAPSHOT.jar login-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","login-0.0.1-SNAPSHOT.jar"]
