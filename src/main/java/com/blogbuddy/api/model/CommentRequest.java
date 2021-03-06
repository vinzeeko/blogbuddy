package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class CommentRequest {

    UUID blogId;
    String userName;
    String comment;

}
