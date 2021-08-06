package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor()
public class BlogRequest {

    String userName;
    String title;
    String content;
    Date createdOn;
    Date updatedOn;

}
