FROM maven:3.8.6-openjdk-18

WORKDIR /app

COPY . /app

RUN mvn clean install -DskipTests

CMD ["mvn", "test", "-DsuiteXmlFile=test-suite.xml"]
