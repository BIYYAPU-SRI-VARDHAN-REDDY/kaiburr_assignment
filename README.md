# kaiburr_assignment-(TASK-1)
Task 1. Java REST API example.
Implement an application in java which provides a REST API with endpoints for searching,
creating and deleting “server” objects:
● GET servers. Should return all the servers if no parameters are passed. When server id
is passed as a parameter - return a single server or 404 if there’s no such a server.
● PUT a server. The server object is passed as a json-encoded message body. Here’s an
example:
{
“name”: ”my centos”,
“id”: “123”,
“language”:”java”,
“framework”:”django”
}
● DELETE a server. The parameter is a server ID.
● GET (find) servers by name. The parameter is a string. Must check if a server name
contains this string and return one or more servers found. Return 404 if nothing is found.
“Server” objects should be stored in MongoDB database.
Be sure that you can show how your application responds to requests using postman, curl or
any other HTTP client

# steps to the solution
To create this application, we will use the Spring Boot framework, which simplifies the development of REST APIs.

Prerequisites:

    Java 8 or higher installed
    MongoDB installed and running

Step 1: Create a Spring Boot project
We will use the Spring Initializr to create a new Spring Boot project. Go to https://start.spring.io/ and select the following options:

    Project: Maven Project
    Language: Java
    Spring Boot: 2.5.6
    Group: com.example
    Artifact: server-api
    Dependencies: Spring Web, Spring Data MongoDB

Click "Generate" and download the generated project.

Step 2: Set up the MongoDB connection
In the application.properties file, add the following configuration to set up the MongoDB connection:

kotlin

    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=server-db

Note: here "server-db" is the database.

Step 3: Create the Server model
Create a new package "model" and create the Server model class in it.

Step 4: Create the Server controller
Create a new package "controller" and create the ServerController class in it

Step 5: Create the Server repository
Create a new package "repository" and create the ServerRepository interface in it
