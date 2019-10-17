drop table if exists account;

create table account(
    ID int(11) not null comment '编号',
    UID int(11) default null comment '用户编号',
    MONEY double default null comment '金额',
    PRIMARY KEY (ID),
    CONSTRAINT fk_a_u foreign key (UID) references user(id)
)engine = InnoDB default charset =utf8;

insert into account (ID, UID, MONEY) values (1,56,1000),(2,56,2000),(3,59,500);

select account.MONEY from user,account where user.id=56 and user.id=account.UID;
select * from account;