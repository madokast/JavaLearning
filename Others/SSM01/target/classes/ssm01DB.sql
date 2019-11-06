use ssm01;
create table account(
    id int primary key auto_increment,
    name varchar(20),
    money double
);

insert into account(name, money) values ("ssm",233);