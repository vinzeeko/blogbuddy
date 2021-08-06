package com.blogbuddy.api.repository;

import com.blogbuddy.api.repository.entity.UserEntity;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query("SELECT * FROM user WHERE username = ?0 AND password = ?1 LIMIT 1")
    UserEntity authUser(String username, String password);

}
