package com.blogbuddy.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor()
public class BlogResponse {

    UUID blogId;
    UUID userId;
    String title;
    String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    Date createdOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    Date updatedOn;

}
