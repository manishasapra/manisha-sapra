FROM maven:3.8.6-openjdk-18 as builder

WORKDIR /app

COPY pom.xml .
COPY test-suite.xml .
COPY src ./src

RUN mvn test-compile

FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

WORKDIR /app

COPY --from=builder /app /app

CMD ["mvn", "test", "-Dsurefire.suiteXmlFiles=test-suite.xml"]
