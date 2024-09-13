# Use Eclipse Temurin with JDK 22 as the base image for building
FROM eclipse-temurin:22-jdk-alpine AS build

# Install Maven
RUN apk add --no-cache maven

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use Eclipse Temurin with JDK 22 as the base image for runtime
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/orange-app-api-0.0.1-SNAPSHOT.jar ./orange-app-api-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/orange-app-api-0.0.1-SNAPSHOT.jar"]
