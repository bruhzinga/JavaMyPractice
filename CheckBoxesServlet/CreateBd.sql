create database presidents;
use presidents;

create table presidents (
id int primary key auto_increment,
last_name nvarchar(20),
countUsers int
);

insert into presidents (last_name, countUsers)
values ('Timofei', 20),
('Natasha', 30),
('Kristina', 15),
('Stepa', 25);