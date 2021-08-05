package com.blogbuddy.api.controller;

import com.blogbuddy.api.mapper.BlogObjectMapper;
import com.blogbuddy.api.model.BlogDto;
import com.blogbuddy.api.model.BlogRequest;
import com.blogbuddy.api.model.BlogResponse;
import com.blogbuddy.api.service.BlogService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/blogs")
public class BlogController {


    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<BlogDto> listBlogs() {

        log.info("Listing all the blogs");
        // TODO Sort it by creation/update time
        return blogService.listBlogs();
    }

    @GetMapping("/{userId}")
    public List<BlogDto> listBlogsByUser(@PathVariable("userId") UUID userId) {
        log.info("Listing blogs for the user {}", userId);
        // TODO Sort it by creation/update time
        return blogService.listBlogsByUser(userId);
    }

    @ApiOperation(value = "creates a new blog", consumes = APPLICATION_JSON_VALUE)
    @PostMapping
    public BlogResponse createBlog(@RequestBody BlogRequest blogRequest) {
        log.info("Creating a new blog for user {} with title {}", blogRequest.getUserId(), blogRequest.getTitle());
        return BlogObjectMapper.mapToBlogResponse(blogService.createBlog(blogRequest));
    }

}
