create database if not exists school;
use school;

CREATE TABLE if not exists  Dept(
	Did int auto_increment primary key ,
	Dname varchar(10) unique not null default '计算机系'
);

CREATE TABLE if not exists  Student(
	Sid int auto_increment,
	Sname varchar(10) not null,
	Ssex varchar(3) default 'M',
	Sage int ,
	Sdept int,
	constraint ckSex check(Ssex in ('M','F')),
	constraint ckAge check(Sage>=15 and Sage<=45),
	constraint sfk foreign key(Sdept) references Dept(Did),
	constraint spk primary key(Sid)
);

CREATE TABLE if not exists  Course(
	Cid int auto_increment,
	Cname varchar(10) not null ,
	Ccredit int,
	constraint chcr check(Ccredit>0),
	constraint cpk primary key(Cid)
);

CREATE TABLE if not exists  Score(
    Sid int not null ,
    Cid int not null ,
    Grade double,
    CONSTRAINT scpk PRIMARY key(Sid,Cid),
    CONSTRAINT scsfk FOREIGN key (Sid) references Student(Sid),
    CONSTRAINT scck FOREIGN key (Cid) references Course(Cid),
    CONSTRAINT gch CHECK(Grade >= 0.0 and Grade<=  100.0)
);

-- ---------------------------------

create table if not exists  Account(
    Aid int auto_increment primary key ,
    name VARCHAR(10) not null ,
    balance double default 0.0,
    create_time timestamp
);

insert into Account(name, balance) values ('zrx',100),('miao',10000);

-- ---------------------------------