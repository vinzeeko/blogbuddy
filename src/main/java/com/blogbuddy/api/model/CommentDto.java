package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class CommentDto {
    UUID commentId;
    UUID blogId;
    UUID userId;
    String userName;
    String comment;
    Date createOn;
}
