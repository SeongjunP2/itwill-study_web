alter session set "_ORACLE_SCRIPT" = true;
create user jspstudy identified by jspstudy;
grant dba to jspstudy;

create table posts (
    id number(6) generated as identity,
    title varchar2(100 char) not null,
    content varchar2(1000 char) not null,
    author varchar2(20) not null,
    created_time timestamp default systimestamp,
    modified_time timestamp default systimestamp,
    constraint posts_id_pk primary key (id)
);

insert into posts (title, content, author)
values ('화요일', 'MVC', 'guest');

commit;

select * from posts order by id desc;

create table users (
    id number(6) generated as identity,
    userid varchar2(20) not null,
    password varchar2(256) not null,
    email varchar2(256) not null,
    points number(7) default 0,
    constraint users_id_pk primary key (id),
    constraint users_userid_uq unique (userid),
    constraint users_email_uq unique (email),
    constraint users_points_ck check (points >= 0)
);

select * from users order by id desc;

select * from posts
where upper(title) like upper('%T%')
    or upper(content) like upper('%t%')
order by id desc;

create table comments (
    id number(6) generated as identity,
    post_id number(6),
    username varchar2(20) not null,
    ctext varchar2(1000 char) not null,
    created_time timestamp default systimestamp,
    modified_time timestamp default systimestamp,
    constraint comments_id_pk primary key (id),
    constraint comments_post_id_fk foreign key (post_id) references posts (id)
);

select * from comments order by id desc;

insert into comments (post_id, username, ctext)
values (63, 'admin', 'text..');

select * from comments where post_id = 63 order by id desc;

update comments set ctext = '댓글 업데이트', modified_time = systimestamp where id = 1;

delete from comments where id = 1;

commit;