FROM openjdk:8-jdk-alpine
WORKDIR /usr/invoiceservice/
ADD ./target/*.jar invoiceservice.jar
EXPOSE 8084
ENTRYPOINT [ "java", "-jar", "invoiceservice.jar"]
