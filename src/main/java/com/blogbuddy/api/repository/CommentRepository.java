package com.blogbuddy.api.repository;

import com.blogbuddy.api.repository.entity.CommentEntity;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<CommentEntity, UUID> {

    @Query("SELECT * FROM comment WHERE blog_id = ?0")
    List<CommentEntity> listCommentsByBlog(UUID blogId);

}
