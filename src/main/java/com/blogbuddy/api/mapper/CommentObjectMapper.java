package com.blogbuddy.api.mapper;

import com.blogbuddy.api.model.CommentDto;
import com.blogbuddy.api.model.CommentRequest;
import com.blogbuddy.api.model.CommentResponse;
import com.blogbuddy.api.repository.entity.CommentEntity;

import java.util.UUID;

public class CommentObjectMapper {

    // To disable instantiation
    private CommentObjectMapper() {
    }

    public static CommentDto mapToCommentDto(CommentEntity commentEntity) {

        CommentDto commentDto = new CommentDto();
        commentDto.setBlogId(commentEntity.getBlogId());
        commentDto.setUserName(commentEntity.getUserName());
        commentDto.setCommentId(commentEntity.getCommentId());
        commentDto.setComment(commentEntity.getComment());
        commentDto.setCreateOn(commentEntity.getCreatedOn());
        return commentDto;
    }

    public static CommentEntity mapToCommentEntity(CommentRequest commentRequest) {

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(UUID.randomUUID());
        commentEntity.setBlogId(commentRequest.getBlogId());
        commentEntity.setUserName(commentRequest.getUserName());
        commentEntity.setComment(commentRequest.getComment());
        return commentEntity;
    }

    public static CommentResponse mapToCommentResponse(CommentDto commentDto) {

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setBlogId(commentDto.getBlogId());
        commentResponse.setUserName(commentDto.getUserName());
        commentResponse.setCommentId(commentDto.getCommentId());
        commentResponse.setComment(commentDto.getComment());
        commentResponse.setCreatedOn(commentDto.getCreateOn());
        return commentResponse;
    }

}
