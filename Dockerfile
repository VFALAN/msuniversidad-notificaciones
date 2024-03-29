FROM openjdk:17-alpine
EXPOSE 8084
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java" , "-jar" , "app.jar"]