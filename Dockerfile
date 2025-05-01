# Start with Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy built jar
COPY target/todo-app-1.0.0.jar todo-app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "todo-app.jar"]
