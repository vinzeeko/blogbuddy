package com.blogbuddy.api.service;

import com.blogbuddy.api.mapper.BlogObjectMapper;
import com.blogbuddy.api.model.BlogDto;
import com.blogbuddy.api.model.BlogRequest;
import com.blogbuddy.api.repository.BlogRepository;
import com.blogbuddy.api.repository.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDto> listBlogs() {

        List<BlogDto> blogDtos = StreamSupport.stream(blogRepository.findAll().spliterator(), false)
                .map(BlogObjectMapper::mapToBlogDto)
                .collect(Collectors.toList());

        blogDtos.sort(Comparator.comparing(BlogDto::getCreateOn).reversed());
        return blogDtos;
    }


    public List<BlogDto> listBlogsByUser(UUID userId) {

        List<BlogDto> blogDtos = blogRepository.listBlogsByUser(userId)
                .stream()
                .map(BlogObjectMapper::mapToBlogDto)
                .collect(Collectors.toList());

        blogDtos.sort(Comparator.comparing(BlogDto::getCreateOn).reversed());
        return blogDtos;
    }

    public BlogDto createBlog(BlogRequest blogRequest) {

        BlogEntity blogEntity = BlogObjectMapper.mapToBlogEntity(blogRequest);
        Date currentDateTime = new Date();
        blogEntity.setCreatedOn(currentDateTime);
        blogEntity.setUpdatedOn(currentDateTime);

        return BlogObjectMapper
                .mapToBlogDto(blogRepository.save(blogEntity));

    }

    public BlogDto viewBlog(UUID blogId) {

        BlogEntity blogEntity = blogRepository.findById(blogId).orElse(null);

        if(blogEntity == null) return null;

        return BlogObjectMapper
                .mapToBlogDto(blogEntity);

    }

}
