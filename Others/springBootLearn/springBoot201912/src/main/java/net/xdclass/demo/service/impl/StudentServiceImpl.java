package net.xdclass.demo.service.impl;

import net.xdclass.demo.domain.Student;
import net.xdclass.demo.mapper.StudentMapper;
import net.xdclass.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 * 服务层实现类
 * <p>
 * Data
 * 2019/12/20 18:11
 *
 * @author zrx
 * @version 1.0
 */

@Service(value = "studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;


    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int add(Student student) {
        return studentMapper.insert(student);
    }


    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
