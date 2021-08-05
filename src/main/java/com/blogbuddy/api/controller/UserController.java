package com.blogbuddy.api.controller;

import com.blogbuddy.api.mapper.UserObjectMapper;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.model.UserResponse;
import com.blogbuddy.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "creates a new user", consumes = APPLICATION_JSON_VALUE)
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        log.info("creating a new user for {}", userRequest.getUsername());
        return UserObjectMapper.mapToUserResponse(userService.createUser(userRequest));
    }



}
