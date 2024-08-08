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
    

create table members (
    id number(9) generated as identity,
    username varchar2(20 char) not null,
    password varchar2(255 char) not null,
    email varchar2(255 char) not null,
    created_time timestamp,
    modified_time timestamp,
    constraint members_pk primary key (id),
    constraint members_uq unique (username)
);

create table member_roles (
    member_id number(9),
    roles varchar2(10 char)
);

alter table member_roles 
add constraint member_roles_fk
    foreign key (member_id) references members (id)
    on delete cascade;
    
select m.*, r.*
from members m
    join member_roles r
        on m.id = r.member_id
where m.username = 'test2';