# Use lightweight Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar from target folder
COPY target/*.jar app.jar

# Expose port (optional)
EXPOSE 8080

# Run application
ENTRYPOINT ["java","-jar","app.jar"]
