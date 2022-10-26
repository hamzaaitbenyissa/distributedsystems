FROM openjdk:8-jdk-alpine
WORKDIR /usr/eureka-discovery/
ADD ./target/*.jar eureka-discovery.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "eureka-discovery.jar"]
