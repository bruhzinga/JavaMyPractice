create database task8;
use task8;

create table users (
                      id int primary key auto_increment,
                      password nvarchar(20),
                      role nvarchar(20)
                   );

insert into users (password, role)
values ('123456', 'ADMIN'),
       ('123456', 'USER');