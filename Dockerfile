# Use a base image with Gradle installed
FROM gradle:7.4.0-jdk11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle Wrapper files
COPY gradlew .
COPY gradlew.bat .
COPY gradle/wrapper ./gradle/wrapper/

# Copy the Gradle files
COPY build.gradle.kts .
COPY settings.gradle.kts .
#COPY gradle.properties .

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew build --debug

# Use a smaller base image for the runtime environment
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/onlineShopping-0.0.1-SNAPSHOT.jar demo.jar

# Expose the port
EXPOSE 8080

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "demo.jar"]
