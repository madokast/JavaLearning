package net.xdclass.demo.service;

import net.xdclass.demo.domain.Student;
import net.xdclass.demo.mapper.StudentMapper;

import java.util.List;

/**
 * Description
 * 服务层
 * <p>
 * Data
 * 2019/12/20 18:09
 *
 * @author zrx
 * @version 1.0
 */

public interface StudentService {

    /**
     * 插入
     * @see StudentMapper
     * @param student 对象
     * @return ？？
     */
    int add(Student student);

    List<Student> getAll();

    Student findById(Long id);

    void update(Student student);

    void delete(Long id);

    int addException(Student student);

}
