FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-servr-0.0.1-SNAPSHOT.jar"]
