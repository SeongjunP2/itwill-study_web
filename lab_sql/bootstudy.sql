create table posts (
    id number(9) generated as identity,
    title varchar2(100 char) not null,
    content varchar2(1000 char) not null,
    author varchar2(20 char) not null,
    created_time timestamp,
    modified_time timestamp,
    constraint posts_id_pk primary key(id)
);

insert into posts (title, content, author, created_time, modified_time)
values ('Test title', 'Test content', 'Test author');

commit;

select * from posts;

create table comments (
    id number(9) generated as identity,
    post_id number(9) not null,
    ctext varchar2(500 char) not null,
    writer varchar2(20 char) not null,
    created_time timestamp,
    modified_time timestamp,
    constraint comments_pk_id primary key(id)
);

alter table comments
add constraint fk_comments_ref_posts
    foreign key (post_id) references posts (id)
    on delete cascade;