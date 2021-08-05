package com.blogbuddy.api.repository;

import com.blogbuddy.api.repository.entity.BlogEntity;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BlogRepository extends CrudRepository<BlogEntity, UUID> {

    @Query("SELECT * FROM blog WHERE user_id = ?0")
    List<BlogEntity> listBlogsByUser(UUID userId);

}
