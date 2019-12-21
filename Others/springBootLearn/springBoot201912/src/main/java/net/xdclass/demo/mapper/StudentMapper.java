package net.xdclass.demo.mapper;

import net.xdclass.demo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description
 * 相当于 student dao
 * <p>
 * Data
 * 2019/12/20 17:54
 *
 * @author zrx
 * @version 1.0
 */

//使用interface
@Repository
public interface StudentMapper {

    /**
     * 插入
     * @ Insert 写sql语句
     * #{name} 取 Student 中的值。预编译
     * 用 ${name} 也可以 但是可能会有注入。$-不预编译
     *
     * @ Options 拿到mysql中自增主键id
     * keyProperty java 对象 field名字
     * keyColumn 表中 属性名
     *
     * @param student 插入的对象
     * @return ？？
     */
    @Insert("insert into student(name, phone, create_time, age) VALUES(#{name},#{phone},#{createTime},#{age})")
    @Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
    int insert(Student student);

    @Select("select * from student")
    //表属性名和Java类属性名整合
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    List<Student> getAll();

    @Select("select * from student where id = #{id}")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    Student findById(Long id);

    @Update("update student set name = #{name} where id = #{id}")
    void update(Student student);

    @Delete("delete from student where id = #{id}")
    void delete(Long id);

}
