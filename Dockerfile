FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/programming_course-0.0.1-SNAPSHOT.jar app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]