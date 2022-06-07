create database task3;
use task3;

create table users (
                      id int primary key auto_increment,
                      login nvarchar(20),
                      sum int
                   );

insert into users (login, sum)
values  ('user', 0);