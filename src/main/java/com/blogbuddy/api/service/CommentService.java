package com.blogbuddy.api.service;

import com.blogbuddy.api.mapper.CommentObjectMapper;
import com.blogbuddy.api.model.CommentDto;
import com.blogbuddy.api.model.CommentRequest;
import com.blogbuddy.api.repository.CommentRepository;
import com.blogbuddy.api.repository.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDto createComment(CommentRequest commentRequest) {

        CommentEntity commentEntity = CommentObjectMapper.mapToCommentEntity(commentRequest);
        Date currentDateTime = new Date();
        commentEntity.setCreatedOn(currentDateTime);

        return CommentObjectMapper
                .mapToCommentDto(commentRepository.save(commentEntity));

    }

    public List<CommentDto> listCommentsByBlog(UUID blogId) {

        return commentRepository.listCommentsByBlog(blogId)
                .stream()
                .map(CommentObjectMapper::mapToCommentDto)
                .collect(Collectors.toList());

    }

}
