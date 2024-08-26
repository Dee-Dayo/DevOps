package com.semicolon.devOps.service;

import com.semicolon.devOps.dtos.requests.UserRegisterRequest;
import com.semicolon.devOps.dtos.response.UserRegisterResponse;
import com.semicolon.devOps.model.User;
import com.semicolon.devOps.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        validateUser(request.getUsername());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        UserRegisterResponse response = new UserRegisterResponse();
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        return response;

    }

    private void validateUser(String username) {
        boolean isUserRegistered = userRepository.existsByUsername(username);
        if (isUserRegistered) {
            throw new RuntimeException("Username already exists");
        }
    }

}
