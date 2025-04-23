# Pet Store API Automation (RestAssured)

This repository contains the dockerised CRUD automation framework for operations on PET store.

---

# Tech Stack

###  Reason to choose the below tech stack :
Primary reason was to use RestAssured in order to automate the PET store APIs. I also have hands-on experience on the below technologies and assignment documents says these technologies are are being using in N26.

- Java 17+
- Maven 3.8+
- TestNG
- RestAssured
- Lombok
- Extent Reports
- Docker

---
## Setup Instructions

- Prerequisite
  - Setup PET store locally based on the setup instructions given here : [Visit Pet Store](https://github.com/swagger-api/swagger-petstore)


- Clone the repository
  <pre>git clone https://github.com/manishasapra/manisha-sapra</pre>
- Change directory to the cloned repository
  <pre>cd manisha-sapra/Task_3</pre>

### Run with Docker :

- Prerequisites
  <pre>Install docker for containerized test runs<br/></pre>
- Build docker image
  <pre>docker build -t n26-restassured-tests .</pre>
- Run docker container
  <pre>docker run n26-restassured-tests</pre>

### Run without Docker :

- Prerequisites
  <pre>Ensure Java 17+ is installed.<br/>Install Maven (version 3.8+ recommended)<br/></pre>
- Run with testng
  <pre>mvn test -Dsurefire.suiteXmlFiles=test-suite.xml</pre>

---
## Framework Highlights

### Scalability :
The framework is designed in such a way that it is capable of handling thousands of cases. Though only test cases using RestAssured is being automated as part of this task but the framework is capable of supporting all type of automation tools an technologies.

### Maintainability :
This framework is very easy to maintain as all the dependencies are at one place also `DataProviders` are being used which makes the case independent to run on any kind of data.

### Parallel Execution :
The test cases are running parallely to save time and increase efficiency.

### Dockerised :
As this framework is dockerised which gives it a flexibility to run on any platform and easy to integrate with CI/CD.
