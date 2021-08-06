package com.blogbuddy.api.controller;

import com.blogbuddy.api.exception.ResourceNotFoundException;
import com.blogbuddy.api.exception.UnauthorizedException;
import com.blogbuddy.api.mapper.UserObjectMapper;
import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.model.UserResponse;
import com.blogbuddy.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin
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
        log.info("creating a new user for {}", userRequest.getUserName());
        return UserObjectMapper.mapToUserResponse(userService.createUser(userRequest));
    }

    @ApiOperation(value = "authenticate user", consumes = APPLICATION_JSON_VALUE)
    @PostMapping("/authenticate")
    public ResponseEntity<UserResponse> authUser(@RequestBody UserRequest userRequest) {
        log.info("authenticating for user {}", userRequest.getUserName());

        UserDto userDto =  userService.authUser(userRequest);

        if (userDto == null) throw new UnauthorizedException("Invalid Credentials", HttpStatus.UNAUTHORIZED.value());

        return ResponseEntity.ok(UserObjectMapper.mapToUserResponse(userDto));
    }

    @ApiOperation(value = "updates user theme", consumes = APPLICATION_JSON_VALUE)
    @PutMapping("/{username}")
    public UserResponse updateUserTheme(@PathVariable("username") String username,
                                        @RequestBody UserRequest userRequest) {
        log.info("updating theme for {}", userRequest.getUserName());

        UserDto updatedUserDto =  userService.updateUserTheme(username, userRequest);

        if (updatedUserDto == null) throw new ResourceNotFoundException("User Not Found!");

        return UserObjectMapper.mapToUserResponse(updatedUserDto);
    }
}
