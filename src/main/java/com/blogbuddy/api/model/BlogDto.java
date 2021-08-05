package com.blogbuddy.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class BlogDto {
    UUID blogId;
    UUID userId;
    String title;
    String content;
    Date createOn;
    Date updateOn;
}
