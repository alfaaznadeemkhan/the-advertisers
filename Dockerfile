# Use a lightweight Java runtime as the base image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY tad.jar app.jar

# Expose port 8080 (optional — Render ignores this but good for local dev)
EXPOSE 8080

# Run the Spring Boot app, dynamically binding to Render's assigned port
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:8080}"]
