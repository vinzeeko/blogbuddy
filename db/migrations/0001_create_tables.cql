CREATE TABLE blog (

    // key
    blog_id uuid,
    user_id uuid,
    title text,
    content text,

    // audit
    created_on timestamp,
    updated_on timestamp,

    primary key (blog_id)
);

CREATE INDEX ON blog (user_id);

CREATE TABLE user (

    // key
    user_id uuid,

    username text,
    password text,
    selected_theme int,

    // audit
    created_on timestamp,
    updated_on timestamp,

    primary key (user_id)
);


CREATE TABLE comment (

    // key
    comment_id uuid,
    user_id uuid,
    username text,
    blog_id uuid,
    comment text,

    // audit
    created_on timestamp,

    primary key (comment_id)
);

CREATE INDEX ON comment (blog_id);

-- Creating sample data
-- To be removed
INSERT INTO user (user_id, username, password)
  VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b47, 'service-user','service-pwd');

INSERT INTO user (user_id, username, password)
VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b47, 'comment-user','comment-pwd');


INSERT INTO blog (blog_id, user_id, title, content)
  VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b57, 6ab09bec-e68e-48d9-a5f8-97e6fb4c9b47, 'My First Blog','Oh there is lot to share here');


INSERT INTO comment (comment_id, user_id, blog_id, comment)
  VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b37, 6ab09bec-e68e-48d9-a5f8-97e6fb4c9b47, 6ab09bec-e68e-48d9-a5f8-97e6fb4c9b57, 'here goes my first comment');
