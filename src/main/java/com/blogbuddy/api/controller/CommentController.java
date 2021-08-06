package com.blogbuddy.api.controller;

import com.blogbuddy.api.mapper.CommentObjectMapper;
import com.blogbuddy.api.model.CommentRequest;
import com.blogbuddy.api.model.CommentResponse;
import com.blogbuddy.api.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{blogId}")
    public List<CommentResponse> listCommentsByBlog(@PathVariable("blogId") UUID blogId) {

        log.info("listing all the comments by blog {}", blogId);
        List<CommentResponse> commentResponses = commentService.listCommentsByBlog(blogId)
                .stream()
                .map(CommentObjectMapper::mapToCommentResponse)
                .collect(Collectors.toList());

        // sorting the response by created time in ascending order
        commentResponses.sort(Comparator.comparing(CommentResponse::getCreatedOn));

        return commentResponses;
    }

    @ApiOperation(value = "creates a new comment", consumes = APPLICATION_JSON_VALUE)
    @PostMapping
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        log.info("creating a new comment for user {} for the blog {}", commentRequest.getUserName(),
                commentRequest.getBlogId());
        return CommentObjectMapper.mapToCommentResponse(commentService.createComment(commentRequest));
    }

}
