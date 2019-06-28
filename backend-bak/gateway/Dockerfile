FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8079
ENTRYPOINT ["java","-jar","gateway-0.0.1-SNAPSHOT.jar"]
