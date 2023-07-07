# 🚕 taxi-service 🚕

## Description
Simple web application that supports CRUD operations and authentication.

## Features
- registration user like a driver;
- authentication (login);
- create/update/remove a manufacturer;
- create/update/remove a driver;
- create/update/remove a car;
- display list of manufacturers;
- display list of drivers;
- display list of cars;
- display list of cars of certain driver;

## Technologies
- Java 11
- Maven 3.8.6
- Apache Tomcat 9.0.68
- Java Servlet API 4.0.1
- JSTL 1.2
- MySQL 8.0.32

## How to run

### Prerequisites
- Java
- Maven
- Apache Tomcat
- MySQL database

### Steps
- Run script from the `resources/init_db.sql` file.
- Add environment variables `db_user` and `db_pass` to the run/debug section of run configuration.
- Check database connection parameters in the `com/itzroma/mate/taxiservice/util/ConnectionUtil.java`.
- Run the app from favorite IDE.
- Go to the http://localhost:8080.