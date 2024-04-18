# Use a base image with Gradle installed
FROM gradle:7.4.0-jdk11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle files
COPY . .

# Copy the source code
COPY src ./src

# Build the application
RUN gradle build --no-daemon

# Use a smaller base image for the runtime environment
FROM openjdk:17.0.1-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/onlineShopping-0.0.1-SNAPSHOT.jar demo.jar

# Expose the port
EXPOSE 8080

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "demo.jar"]
