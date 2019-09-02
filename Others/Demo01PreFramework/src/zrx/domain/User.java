package zrx.domain;

/**
 * javaBean
 *
 * create database demo01PreFramework;
 * use demo01PreFramework;
 * create table user(
 *     id int primary key auto_increment,
 *     name varchar(10) not null,
 *     gender varchar(5),
 *     age int
 * );
 */

public class User {
    private int id;
    private String name;
    private String gender;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
