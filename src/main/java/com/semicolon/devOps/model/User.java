package com.semicolon.devOps.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private String password;
    private boolean isLoggedIn;
}