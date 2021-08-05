package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor()
public class UserRequest {

    String username;
    // Encrypted at the front-end
    // it is one way hashing and we wouldnt be able to decrypt back to clear text
    String password;
    int selectedTheme;
    Date createdOn;
    Date updatedOn;

}
