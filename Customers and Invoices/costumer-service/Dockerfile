FROM openjdk:8-jdk-alpine
WORKDIR /usr/customerservice/
ADD ./target/*.jar customerservice.jar
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "customerservice.jar"]
