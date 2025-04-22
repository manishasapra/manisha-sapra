FROM maven:3.8.6-openjdk-18 as builder

WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY test-suite.xml .
COPY src ./src

# Download dependencies and build test classes
RUN mvn test-compile

# Final stage
FROM openjdk:17-jdk-slim

# Install Maven in the final image
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

WORKDIR /app

COPY --from=builder /app /app

# Run the tests using Maven
CMD ["mvn", "test", "-Dsurefire.suiteXmlFiles=test-suite.xml"]
