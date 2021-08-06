CREATE TABLE blog (

    // key
    blog_id uuid,
    username text,
    title text,
    content text,

    // audit
    created_on timestamp,
    updated_on timestamp,

    primary key (blog_id)
);

CREATE INDEX ON blog (username);

CREATE TABLE user (

    // key
    username text,

    password text,
    selected_theme int,

    // audit
    created_on timestamp,
    updated_on timestamp,

    primary key (username)
);

CREATE INDEX ON user (password);


CREATE TABLE comment (

    // key
    comment_id uuid,
    blog_id uuid,
    username text,
    comment text,

    // audit
    created_on timestamp,

    primary key (comment_id)
);

CREATE INDEX ON comment (blog_id);

-- Creating sample data
-- To be removed
INSERT INTO user (username, password)
  VALUES ('service-user','service-pwd');

INSERT INTO user (username, password)
VALUES ('comment-user','comment-pwd');


INSERT INTO blog (blog_id, username, title, content)
  VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b57, 'service-user', 'My First Blog','Oh there is lot to share here');


INSERT INTO comment (comment_id, username, blog_id, comment)
  VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b37, 'comment-user', 6ab09bec-e68e-48d9-a5f8-97e6fb4c9b57, 'here goes my first comment');
