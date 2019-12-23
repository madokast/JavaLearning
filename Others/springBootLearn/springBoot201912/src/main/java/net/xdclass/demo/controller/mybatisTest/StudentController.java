package net.xdclass.demo.controller.mybatisTest;

import net.xdclass.demo.domain.Student;
import net.xdclass.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/20 18:14
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/mybatis")
public class StudentController {

//    @Resource(name = "studentServiceImpl")
    private final StudentService studentServiceImpl;


    @Autowired
    public StudentController(@Qualifier("studentServiceImpl") StudentService studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @RequestMapping("/add")
    public Object add(@RequestBody Student student){
        student.setCreateTime(new Date());

        int id = studentServiceImpl.add(student);

        Map<String,Object> map = new HashMap<>();

        map.put("value",student.toString());
        map.put("back",id);

        return map;
    }


    /**
     * http://localhost:8090/mybatis/getall
     * @return http://localhost:8090/mybatis/getall
     */
    @GetMapping("/getall")
    public Object getAll(){
        Map<String,Object> map = new HashMap<>();

        map.put("getAll",studentServiceImpl.getAll());

        return map;
    }


    /**
     * http://localhost:8090/mybatis/findbyid?id=2
     * @param id http://localhost:8090/mybatis/findbyid?id=2
     * @return http://localhost:8090/mybatis/findbyid?id=2
     */
    @GetMapping("/findbyid")
    public Object findById(Long id){
        Map<String,Object> map = new HashMap<>();

        map.put("findById",studentServiceImpl.findById(id));

        return map;
    }

    /**
     * http://localhost:8090/mybatis/update
     *
     * {
     * 	"id": 1,
     * 	"name": "update",
     * 	"age": 20,
     * 	"phone": "123456"
     * }
     *
     * @param student http://localhost:8090/mybatis/update
     * @return http://localhost:8090/mybatis/update
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Student student){
        studentServiceImpl.update(student);

        Map<String,Object> map = new HashMap<>();

        map.put("update",student);

        return map;
    }


    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public Object delete(@RequestParam Long id){
        studentServiceImpl.delete(id);

        Map<String,Object> map = new HashMap<>();

        map.put("delete",id);

        return map;
    }

    //异常测试

    @RequestMapping("/add/exception")
    public Object addException(@RequestBody Student student){
        student.setCreateTime(new Date());

        int id = studentServiceImpl.addException(student);

        Map<String,Object> map = new HashMap<>();

        map.put("value",student.toString());
        map.put("back",id);

        return map;
    }



    //List<Student> getAll();
    //
    //    Student findById(Long id);
    //
    //    void update(Student student);
    //
    //    void delete(Long id);
}
