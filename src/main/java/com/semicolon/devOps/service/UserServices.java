package com.semicolon.devOps.service;

import com.semicolon.devOps.dtos.requests.LoginRequest;
import com.semicolon.devOps.dtos.requests.UserRegisterRequest;
import com.semicolon.devOps.dtos.response.LoginResponse;
import com.semicolon.devOps.dtos.response.UserRegisterResponse;
import com.semicolon.devOps.model.User;
import com.semicolon.devOps.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserService{
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

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

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = findUserByName(loginRequest.getUsername());
        validatePassword(loginRequest);

        return modelMapper.map(user, LoginResponse.class);
    }
    private User findUserByName(String username) {
        User user = userRepository.findDevUserByUsernameIgnoreCase(username);
        if (user == null) throw new RuntimeException(username + " does not exist");
        return user;
    }
    private void validatePassword(LoginRequest loginRequest) {
        User user = findUserByName(loginRequest.getUsername());
        if(!user.getPassword().equals(loginRequest.getPassword())) throw new RuntimeException("Wrong password");
    }

}
