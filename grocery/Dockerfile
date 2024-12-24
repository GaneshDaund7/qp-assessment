
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app


COPY target/grocery-app.jar app.jar

# Expose the application port (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
