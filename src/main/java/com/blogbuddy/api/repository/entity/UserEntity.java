package com.blogbuddy.api.repository.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Table("user")
public class UserEntity {

    @PrimaryKey("username")
    private String userName;

    @Column("password")
    private String password;

    @Column("selected_theme")
    private int selectedTheme;

    @Column("created_on")
    private Date createdOn;

    @Column("updated_on")
    private Date updatedOn;

}
