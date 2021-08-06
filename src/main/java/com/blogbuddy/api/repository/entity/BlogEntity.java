package com.blogbuddy.api.repository.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table("blog")
public class BlogEntity {

    @PrimaryKey("blog_id")
    private UUID blogId;

    @Column("username")
    private String userName;

    @Column("content")
    private String content;

    @Column("title")
    private String title;

    @Column("created_on")
    private Date createdOn;

    @Column("updated_on")
    private Date updatedOn;

}
