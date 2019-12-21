/*
  public class Student
    private int id;
    private String name;
    private String phone;
    private int age;
    private Date createTime;
*/

# drop table student;

create table if not exists student (
                                       id int primary key auto_increment,
                                       name varchar(128) ,
                                       phone varchar(16) ,
                                       create_time timestamp ,
                                       age int
)
    engine=InnoDB default charset=utf8;

insert into student(name, phone, age) VALUES('zrx','10010000',14);