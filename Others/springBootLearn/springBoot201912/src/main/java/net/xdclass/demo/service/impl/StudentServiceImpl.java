package net.xdclass.demo.service.impl;

import net.xdclass.demo.domain.Student;
import net.xdclass.demo.mapper.StudentMapper;
import net.xdclass.demo.service.StudentService;
import net.xdclass.demo.utils.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    private final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);


    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        LOG.info("StudentServiceImpl实例化");

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


    /**
     * 事务 异常处理
     * @param student 学生
     * @return 不应该执行成功
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addException(Student student) {
        final int insert = studentMapper.insert(student);

        //异常
        int i = 1/0;

        return insert;
    }
}
