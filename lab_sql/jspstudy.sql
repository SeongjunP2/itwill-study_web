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