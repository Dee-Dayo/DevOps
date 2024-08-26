package com.semicolon.devOps.dtos.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserRegisterRequest {
    private String username;
    private String password;
}
