##########################################
# 1️⃣ BUILD STAGE — Compile Spring Boot app
##########################################
FROM eclipse-temurin:21-jdk AS build

# Set working directory
WORKDIR /app

# Copy Maven files and download dependencies first (for better cache use)
COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline -B

# Copy actual source code and build
COPY src src
RUN ./mvnw clean package -DskipTests

##########################################
# 2️⃣ RUN STAGE — Lightweight runtime image
##########################################
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose default port (Render sets PORT dynamically)
EXPOSE 8080

# Set Java memory optimizations (tune as needed)
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Dfile.encoding=UTF-8"

# Run the Spring Boot app, using Render's PORT if available
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar --server.port=${PORT:-8080}"]
