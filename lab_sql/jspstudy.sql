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
values ('test', 'Servlet/JSP test', 'admin');

commit;

select * from posts;