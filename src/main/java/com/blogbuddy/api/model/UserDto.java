package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class UserDto {

    UUID userId;
    String userName;
    int selectedTheme;
    Date createOn;
    Date updateOn;
}
