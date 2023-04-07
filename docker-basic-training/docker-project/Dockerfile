FROM openjdk:17-alpine

WORKDIR /app

COPY target/docker-project.jar .

EXPOSE 8080

CMD ["java", "-jar", "docker-project.jar"]
