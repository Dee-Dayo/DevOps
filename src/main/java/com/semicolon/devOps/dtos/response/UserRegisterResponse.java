package com.semicolon.devOps.dtos.response;

import lombok.Data;

@Data
public class UserRegisterResponse {
    private String userId;
    private String username;
    private String password;
}
