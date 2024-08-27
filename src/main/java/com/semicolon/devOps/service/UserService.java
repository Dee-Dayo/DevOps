package com.semicolon.devOps.service;

import com.semicolon.devOps.dtos.requests.LoginRequest;
import com.semicolon.devOps.dtos.requests.UserRegisterRequest;
import com.semicolon.devOps.dtos.response.LoginResponse;
import com.semicolon.devOps.dtos.response.UserRegisterResponse;

public interface UserService {
     UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
     LoginResponse login(LoginRequest loginRequest);
}
