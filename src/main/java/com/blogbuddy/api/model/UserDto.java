package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor()
public class UserDto {

    String userName;
    int selectedTheme;
    Date createOn;
    Date updateOn;
}
