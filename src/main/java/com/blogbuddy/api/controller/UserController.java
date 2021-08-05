package com.blogbuddy.api.controller;

import com.blogbuddy.api.exception.NotFoundException;
import com.blogbuddy.api.mapper.UserObjectMapper;
import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.model.UserResponse;
import com.blogbuddy.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @ApiOperation(value = "updates user theme", consumes = APPLICATION_JSON_VALUE)
    @PutMapping("/{userId}")
    public UserResponse updateUserTheme(@PathVariable("userId") UUID userId,
                                        @RequestBody UserRequest userRequest) {
        log.info("updating theme for {}", userRequest.getUsername());

        UserDto updatedUserDto =  userService.updateUserTheme(userId, userRequest);

        if (updatedUserDto == null) throw new NotFoundException("User Not Found!");

        return UserObjectMapper.mapToUserResponse(updatedUserDto);
    }
}
