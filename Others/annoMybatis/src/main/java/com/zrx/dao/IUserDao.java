package com.zrx.dao;

import com.zrx.domain.User;
import com.zrx.domain.Userx;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.Test;

import java.util.List;

//    @Results(id = "accountMap",
//            value = {
//            @Result(id = true,column = "id",property = "id"),
//            @Result(column = "uid",property = "uid"),
//            @Result(column = "money",property = "money"),
//            @Result(column = "uid",property = "user",
//                    one = @One(select = "com.zrx.dao.IUserDao.findById",fetchType = FetchType.EAGER))
//    })

@CacheNamespace(blocking = true)//二级缓存
public interface IUserDao {
    @Select("select * from user")
    @Results(id="userMap",
            value = {
            @Result(column = "id",property = "accounts",
            many = @Many(select = "com.zrx.dao.IAccountDao.findAccountById",fetchType = FetchType.LAZY))
            }
    )
    List<User> findAll();

    @Insert("insert into user(username, birthday, sex, address) values (#{username}, #{birthday}, #{sex}, #{address});")
    void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(User user);

    @Update("update user set username=#{username}, address=#{address}, birthday=#{birthday},sex=#{sex} where id = #{id};")
    void updateUser(User user);

    @Select("select * from user where username like #{name}")
    List<User> findByName(String name);

    @Select("select count(*) from user")
    Integer findTotal();

    @Select("select * from user")
    @Results(id = "userX",value = {
            @Result(id = true,column = "id",property = "uid"),
            @Result(column = "username",property = "userName")
    })
    List<Userx> findAllX();

    @Select("select * from user where id = #{id}")
    User findById(Integer id);


}
