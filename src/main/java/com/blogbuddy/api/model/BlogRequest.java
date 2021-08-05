package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class BlogRequest {

    UUID userId;
    String title;
    String content;
    Date createdOn;
    Date updatedOn;

}
