<h1 align="center">Stock and sales control system - SSCS</h1>

<h2>Project status:</h2>🚀 In progress 🚧

## Description:
this project is an application developed to represent an inventory and sales control system. The application is divided into some microservices that make up the application as a whole, namely:
### ms-register-provider
service that manages providers
### ms-register-products
service that manages products
## Technologies/dependencies:
* Java
* Spring Rest
* Spring Security
* Spring boot Validation
* Docker
* Swagger
* Gradle

## Features:
- [x] Configure the Docker
- [ ] Configure the Jenkins
- [ ] Create microservice for provider
- [ ] Create microservice for product
- [ ] Create microservice for stock
- [ ] Create microservice for sales
- [ ] Implement spring security
- [ ] Implement unit tests
- [ ] Implement integration tests
- [ ] Make API integration with Angular

## Prerequisites to run the application:
- Docker
- Java v17
- Gradle v7.1.4
## Open and run the project:
- Clone the repository:
```bash
$ git clone https://github.com/andressamorschel/SSCS.git
```
- In the root directory, lift the docker container:
```bash
$ docker-compose up
```
- Go to the directory of one of the services and start:
```bash
$ gradle bootrun
```
<h4 align="center">Developed by Andressa Morschel👩‍💻</h4>
