create database task2;
use task2;

create table comments (
                          id int primary key auto_increment,
                          text nvarchar(200),
                          like int,
                          dislike int);

insert into comments (text, like, dislike)
values  ('test post', 0, 0),
        ('test post2', 0, 0);