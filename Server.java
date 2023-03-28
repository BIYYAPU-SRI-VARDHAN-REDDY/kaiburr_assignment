package com.example.serverapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servers")
public class Server {
    @Id
    private String id;

    private String name;

    private String language;

    private String framework;

    // getters and setters omitted for brevity
}
