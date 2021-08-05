package com.blogbuddy.api.service;

import com.blogbuddy.api.mapper.UserObjectMapper;
import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.repository.UserRepository;
import com.blogbuddy.api.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserRequest userRequest) {

        UserEntity userEntity = UserObjectMapper.mapToUserEntity(userRequest);
        Date currentDateTime = new Date();
        userEntity.setCreatedOn(currentDateTime);
        userEntity.setUpdatedOn(currentDateTime);

        return UserObjectMapper
                .mapToUserDto(userRepository.save(userEntity));

    }

    public UserDto updateUserTheme(UUID userId, UserRequest userRequest) {

        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        // User not found
        if(userEntity == null) return null;

        userEntity.setSelectedTheme(userRequest.getSelectedTheme());

        return UserObjectMapper
                .mapToUserDto(userRepository.save(userEntity));

    }

}
