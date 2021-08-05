package com.blogbuddy.api.mapper;

import com.blogbuddy.api.model.BlogDto;
import com.blogbuddy.api.model.BlogRequest;
import com.blogbuddy.api.model.BlogResponse;
import com.blogbuddy.api.repository.entity.BlogEntity;

import java.util.UUID;

public class BlogObjectMapper {

    // To disable instantiation
    private BlogObjectMapper() {
    }

    public static BlogDto mapToBlogDto(BlogEntity blogEntity) {

        BlogDto blogDto = new BlogDto();
        blogDto.setBlogId(blogEntity.getBlogId());
        blogDto.setUserId(blogEntity.getUserId());
        blogDto.setTitle(blogEntity.getTitle());
        blogDto.setContent(blogEntity.getContent());
        blogDto.setCreateOn(blogEntity.getCreatedOn());
        blogDto.setUpdateOn(blogEntity.getUpdatedOn());
        return blogDto;
    }

    public static BlogEntity mapToBlogEntity(BlogRequest blogRequest) {

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setBlogId(UUID.randomUUID());
        blogEntity.setUserId(blogRequest.getUserId());
        blogEntity.setTitle(blogRequest.getTitle());
        blogEntity.setContent(blogRequest.getContent());
        return blogEntity;
    }

    public static BlogResponse mapToBlogResponse(BlogDto blogDto) {

        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setBlogId(blogDto.getBlogId());
        blogResponse.setUserId(blogDto.getUserId());
        blogResponse.setTitle(blogDto.getTitle());
        blogResponse.setContent(blogDto.getContent());
        blogResponse.setCreatedOn(blogDto.getCreateOn());
        blogResponse.setUpdatedOn(blogDto.getUpdateOn());
        return blogResponse;
    }

}
