# Use the official Maven image to build the application
# This image includes Java and Maven
FROM eclipse-temurin:22-jdk-alpine AS build

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

# Use a minimal base image to run the application
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/myapp.jar ./app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
