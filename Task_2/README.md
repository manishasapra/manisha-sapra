# Monefy App Automation (Appium)

This repository contains the dockerised automation framework to perform testing on `Monefy` mobile application.

---

# Tech Stack

###  Reason to choose the below tech stack :
Primary reason was to use RestAssured in order to automate the PET store APIs. I also have hands-on experience on the below technologies and assignment documents says these technologies are are being using in N26.

- Java 17+
- Maven 3.8+
- TestNG
- Appium 2.0
- Lombok
- Extent Reports
- Docker

---
## Setup Instructions

- Prerequisite
    - Setup appium server locally or provide URL for the remote server in `env.properties`.
    - Install `Monefy` application on the android device from playstore.
    - Provide device configurations on `env.properties`


- Clone the repository
  <pre>git clone https://github.com/manishasapra/manisha-sapra</pre>
- Change directory to the cloned repository
  <pre>cd manisha-sapra/Task_2</pre>

### Run with Docker :

- Prerequisites

  `Install docker for containerized test runs`


- Build docker image
  <pre>docker build -t n26-appium-tests .</pre>
- Run docker container
  <pre>docker run -e TZ=Europe/Berlin --rm n26-appium-tests</pre>
    _note: Modify the time zone accordingly if needed as test cases validates the time of the operation._ 

### Run without Docker :

- Prerequisites
  <pre>Ensure Java 17+ is installed.<br/>Install Maven (version 3.8+ recommended)<br/></pre>
- Run with testng
  <pre>mvn test -Dsurefire.suiteXmlFiles=test-suite.xml</pre>

---
## Framework Highlights

### Scalability :
The framework is designed in such a way that it is capable of handling thousands of cases. Though only test cases using Appium is being automated as part of this task but the framework is capable of supporting all type of automation tools an technologies.

### Maintainability :
This framework is very easy to maintain as all the dependencies are at one place also `DataProviders` are being used which makes the case independent to run on any kind of data.

### Dockerised :
As this framework is dockerised which gives it a flexibility to run on any platform and easy to integrate with CI/CD.
