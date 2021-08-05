package com.blogbuddy.api.mapper;

import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.model.UserResponse;
import com.blogbuddy.api.repository.entity.UserEntity;

import java.util.UUID;

public class UserObjectMapper {

    // To disable instantiation
    private UserObjectMapper() {
    }

    public static UserDto mapToUserDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setUserId(userEntity.getUserId());
        userDto.setUserName(userEntity.getUsername());
        userDto.setSelectedTheme(userEntity.getSelectedTheme());
        userDto.setCreateOn(userEntity.getCreatedOn());
        userDto.setUpdateOn(userEntity.getUpdatedOn());
        return userDto;
    }

    public static UserEntity mapToUserEntity(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setSelectedTheme(userRequest.getSelectedTheme());


        return userEntity;
    }

    public static UserResponse mapToUserResponse(UserDto userDto) {

        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(userDto.getUserId());
        userResponse.setUserName(userDto.getUserName());
        userResponse.setSelectedTheme(userDto.getSelectedTheme());
        userResponse.setCreatedOn(userDto.getCreateOn());
        userResponse.setUpdatedOn(userDto.getUpdateOn());
        return userResponse;
    }

}
