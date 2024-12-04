# Interview Project

This project is an application developed using **Hexagonal Architecture** that implements a single endpoint that receives specific parameters, performs a query on an H2 database, and returns the requested information.

## Project Description
- **Spring Boot 3.3.6.**
- **Java 21.**
- **Maven.**
- **Multimodular project.**
- **Embedded H2 database.**

### Key Features
- Includes both unit and integration tests.
- The H2 database is preloaded with the required data, and queries are performed using a **Native Query**.
---

## Project Structure

The project is divided into **four main modules**:

1. ### **Launcher**
   This module initializes the Spring Boot project.

2. ### **Domain**
   Defines the core domain model, including:
    - **`Price`**: Represents the price data in the system.

3. ### **Application**
   Contains the business logic of the application, including:
    - **`FindPriceUseCase`**: Interface defining the use case of finding a price by given the parameters. The price found has to match the productId, brandId and the applicationDate given as a parameters has to be between its startDate and endDate. If more than one product are found, the one with the max priority will be returned.
    - **`FindPriceService`**: Implements the given use case.
    - **`PriceRepository`**: Persistence port that abstracts data access. It has the method needed, but it could have more methods.

4. ### **Infrastructure**
   Handles the implementation of adapters such as REST controllers, configurations, and database integrations. It includes:
    - **REST Controllers**:
      - **`PriceController`**: Manages requests to the primary endpoint.
    - **Mappers and DTOs**:
      - **`GetPriceInfoRequest`** and **`GetPriceInfoResponse`**: DTOs for request and response data for the endpoint.
    - **Exceptions**:
      - **`CustomException`**: This exception has all the fields needed to have all the information needed.
      - **`ExceptionResponse`**: DTO to display all the exceptions handled.
      - **`ExceptionService`**: Service to handle the exceptions thrown.
      - **`PriceNotFoundException`**: Exception thrown when a Price was not found.
    - **Persistence**:
      - **`JpaPriceSpringDataRepository`**: Implementation of JPA.
      - **`JpaPriceRepository`**: Implements the methods on _ProductRepository_ and uses the implementation of JPA to perform the operations on the database.

---



## How to Run the Application

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/Pabgiralv-2/BCNC-Interview.git
    cd BCNC-Interview
    ```

2. Build and run the project
    ```bash
    mvn clean install
    cd launcher
    mvn spring-boot:run
    ```

3. Once the application starts, you can access the endpoint at:
    ```bash
    GET http://localhost:8080/products/search
    ```
   Using this body:
    ```json
   {
       "applicationDate": "2020-06-14T16:00:00",
       "productId": 35455,
       "brandId": 1
   }
    ```
   This is the response:
    ```json
   {
       "productId": "35455",
       "brandId": "1",
       "priceList": 2,
       "startDate": "2020-06-14T15:00:00",
       "endDate": "2020-06-14T18:30:00",
       "price": 25.45
   }
    ```

---


## Execute tests
1. To execute all the tests, go to the main directory and execute:
    ```bash
    mvn test
    ```