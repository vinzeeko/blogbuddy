package com.blogbuddy.api.service;

import com.blogbuddy.api.model.UserDto;
import com.blogbuddy.api.model.UserRequest;
import com.blogbuddy.api.repository.UserRepository;
import com.blogbuddy.api.repository.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    public void shouldAuthenticateUser() {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("user");
        userEntity.setPassword("pwd");

        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("user");
        userRequest.setPassword("pwd");
        // mocking repository response
        when(userRepository.authUser("user", "pwd")).thenReturn(
                userEntity);

        UserDto actual = userService.authUser(userRequest);

        verify(userRepository, times(1)).authUser(userRequest.getUserName(), userRequest.getPassword());

        assertThat(actual.getUserName()).isEqualTo("user");

    }

    @Test
    public void shouldCreateUser() {

        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("user");
        userRequest.setPassword("pwd");

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("user");
        userEntity.setPassword("pwd");

        // mocking repository response
        when(userRepository.save(any(UserEntity.class))).thenReturn(
                userEntity);

        UserDto actual = userService.createUser(userRequest);

        assertThat(actual.getUserName()).isEqualTo("user");

    }
}
