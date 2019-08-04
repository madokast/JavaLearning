use school;
create table if not exists user(
    id int primary key auto_increment,
    username varchar(32) unique not null ,
    password varchar(32) not null
);

insert into user(username, password) values ('zrx','123');

select * from user;