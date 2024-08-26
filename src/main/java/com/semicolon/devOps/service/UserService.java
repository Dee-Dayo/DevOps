package com.semicolon.devOps.service;

import com.semicolon.devOps.dtos.requests.UserRegisterRequest;
import com.semicolon.devOps.dtos.response.UserRegisterResponse;

public interface UserService {
     UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
}
