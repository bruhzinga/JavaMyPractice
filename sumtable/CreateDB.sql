create database mybase;
use mybase;

create table mytable (
                       id int primary key auto_increment,
                       sum int,
                       year int
);

insert into mytable (sum, year)
values  (100, 1945),(-100, 1945),(3, 1945);