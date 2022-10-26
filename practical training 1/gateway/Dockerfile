FROM openjdk:8-jdk-alpine
WORKDIR /usr/gateway/
ADD ./target/*.jar gateway.jar
EXPOSE 9999
ENTRYPOINT [ "java", "-jar", "gateway.jar"]
