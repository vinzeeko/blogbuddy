package com.blogbuddy.api.service;

import com.blogbuddy.api.model.BlogDto;
import com.blogbuddy.api.model.BlogRequest;
import com.blogbuddy.api.repository.BlogRepository;
import com.blogbuddy.api.repository.entity.BlogEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class BlogServiceTest {

    @Mock
    BlogRepository blogRepository;

    @InjectMocks
    BlogService blogService;


    @Test
    public void shouldListBlogs() {

        List<BlogEntity> blogEntityList = new ArrayList<BlogEntity>();
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setUserName("test-user");
        blogEntity.setTitle("title");
        blogEntity.setContent("content");
        blogEntityList.add(blogEntity);

        // mocking repository response
        when(blogRepository.findAll()).thenReturn(
                blogEntityList);

        List<BlogDto> actual = blogService.listBlogs();

        verify(blogRepository, times(1)).findAll();

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0).getTitle()).isEqualTo("title");
        assertThat(actual.get(0).getContent()).isEqualTo("content");

    }

    @Test
    public void shouldCreateBlog() {

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setUserName("test-user");
        blogEntity.setTitle("title");
        blogEntity.setContent("content");

        BlogRequest blogRequest = new BlogRequest();
        blogRequest.setUserName("test-user");
        blogRequest.setTitle("title");
        blogRequest.setContent("content");

        // mocking repository response
        when(blogRepository.save(any(BlogEntity.class))).thenReturn(
                blogEntity);

        BlogDto actual = blogService.createBlog(blogRequest);

        assertThat(actual.getTitle()).isEqualTo("title");
        assertThat(actual.getContent()).isEqualTo("content");

    }
}
