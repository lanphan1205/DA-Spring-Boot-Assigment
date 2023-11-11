# Java Spring Boot RESTful API application

Task Completed:
1. All APIs required are implemented and tested with Postman
2. Error Handling for each endpoint
3. Store task data to local MySQL database using JPA 

Steps To Run:
#### 1. Open this project on a Code Editor (Intellij, etc.) 
#### 2. application.properties
    server.port = 8082
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/da_assignment
    spring.datasource.username=<myql_username>
    spring.datasource.password=<mysql_password>
    spring.datasource.driver-class-name =com.mysql.jdbc.Driver
    spring.jpa.show-sql: true
Create a schema on local MySQL 'da_assignment'. Replace <mysql_username> and <mysql_password> with your local MySQL server username and password
#### 3. Ensure that maven is installed on your machine
#### 4. From project directory, run:
    mvn spring-boot:run
#### 5. Import DA Take-home Assignment.postman_collection.json to Postman to start sending request

Assumptions made:
1. For PUT request, task data is only updated if not empty

Further improvements:
1. Spring Boot Security
    Due to lack of time, I did not manage to implement this feature. Given more time, I plan to use Spring Boot Security with JWT for authentication and authorization. 
    The following are the steps:
    1. Add spring-security and jwt to pom.xml
    2. Create JWTService to handle token management, AuthenticationService for sign-up/sign-in
    3. Create User entity that implements UserDetails from spring boot security. This is to facilitate token validation
    4. Upon signing up, a JWT token is generated from UserDetails.username and sent back to REST client. A JWT token also has other attribute like expiration period and is generate from a secret jwt signing key.
    5. REST client put this JWT token in its Authorisation header. Back-end application validates this token upon any API call for Task data. If the token is not valid, exception can be thrown on server-side and send back to REST client with 401 Unauthorized Status Code
    6. JWTService can also renew the token when it expires.
2. Deploy application on containter
    Due to lack of time, I did not manage to implement this feature. Given more time, I will use Docker for this task. A docker-compose.yaml file should be used, in which we can specify configuration such as database and port,..















