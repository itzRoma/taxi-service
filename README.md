# 🚕 taxi-service 🚕

## Description
Simple web application that supports CRUD operations and authentication.

## Business value
- The project is for a managing taxi company.
- The customer is a company that wants a software to simplify this process.
- The users is drivers of a certain company.

## Features
- Registration user like a driver.
- Authentication (login).
- Create/update/remove a manufacturer.
- Create/update/remove a driver.
- Create/update/remove a car.
- Display list of manufacturers.
- Display list of drivers.
- Display list of cars.
- Display list of cars of certain driver.

## Technologies
- Java 11
- Maven 3.8.6
- Apache Tomcat 9.0.68
- Java Servlet API 4.0.1
- JSP
- JSTL 1.2
- JDBC
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