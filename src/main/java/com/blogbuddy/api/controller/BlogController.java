package com.blogbuddy.api.controller;

import com.blogbuddy.api.exception.ResourceNotFoundException;
import com.blogbuddy.api.mapper.BlogObjectMapper;
import com.blogbuddy.api.model.BlogDto;
import com.blogbuddy.api.model.BlogRequest;
import com.blogbuddy.api.model.BlogResponse;
import com.blogbuddy.api.service.BlogService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/blogs")
public class BlogController {


    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ApiOperation(value = "creates a new blog", consumes = APPLICATION_JSON_VALUE)
    @PostMapping
    public BlogResponse createBlog(@RequestBody BlogRequest blogRequest) {
        log.info("Creating a new blog for user {} with title {}", blogRequest.getUserName(), blogRequest.getTitle());
        return BlogObjectMapper.mapToBlogResponse(blogService.createBlog(blogRequest));
    }

    @ApiOperation(value = "view a blog", produces = APPLICATION_JSON_VALUE)
    @GetMapping("/{blogId}")
    public BlogDto viewBlog(@PathVariable("blogId") UUID blogId) {
        log.info("fetching data for {}", blogId);
        BlogDto blogDto = blogService.viewBlog(blogId);

        if (blogDto == null) throw new ResourceNotFoundException("Blog Not Found!");

        return blogDto;
    }

    @ApiOperation(value = "lists blogs", produces = APPLICATION_JSON_VALUE)
    @GetMapping
    public List<BlogDto> listBlogs(@RequestParam(value = "userId", required = false) Optional<UUID> userId) {

        log.info("Listing blogs");
        if (userId.isPresent()) {
            // lists blogs specific for a user
            return blogService.listBlogsByUser(userId.get());
        }
        // lists all the blogs
        return blogService.listBlogs();
    }

}
