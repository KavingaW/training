FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/student-application.jar .
EXPOSE 8080
CMD ["java", "-jar", "student-application.jar"]
