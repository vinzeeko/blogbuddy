package com.blogbuddy.api.repository.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table("comment")
public class CommentEntity {

    @PrimaryKey("comment_id")
    private UUID commentId;

    @Column("username")
    private String userName;

    @Column("blog_id")
    private UUID blogId;

    @Column("comment")
    private String comment;

    @Column("created_on")
    private Date createdOn;

}
