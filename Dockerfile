FROM openjdk:17-alpine

ARG JAR_FILE=./build/libs/ECommerce-1.0.0.jar

COPY ${JAR_FILE} /app.jar

ENTRYPOINT java -Dspring.profiles.active=${PROFILE} -jar /ECommerce.jar
