package com.blogbuddy.api.mapper;

import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.model.UserResponse;
import com.blogbuddy.api.repository.entity.UserEntity;

public class UserObjectMapper {

    // To disable instantiation
    private UserObjectMapper() {
    }

    public static UserDto mapToUserDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setUserName(userEntity.getUserName());
        userDto.setSelectedTheme(userEntity.getSelectedTheme());
        userDto.setCreateOn(userEntity.getCreatedOn());
        userDto.setUpdateOn(userEntity.getUpdatedOn());
        return userDto;
    }

    public static UserEntity mapToUserEntity(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setSelectedTheme(userRequest.getSelectedTheme());


        return userEntity;
    }

    public static UserResponse mapToUserResponse(UserDto userDto) {

        UserResponse userResponse = new UserResponse();

        userResponse.setUserName(userDto.getUserName());
        userResponse.setSelectedTheme(userDto.getSelectedTheme());
        userResponse.setCreatedOn(userDto.getCreateOn());
        userResponse.setUpdatedOn(userDto.getUpdateOn());
        return userResponse;
    }

}
