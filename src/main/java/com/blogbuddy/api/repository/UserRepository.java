package com.blogbuddy.api.repository;

import com.blogbuddy.api.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

}
