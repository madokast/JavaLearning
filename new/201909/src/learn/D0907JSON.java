package learn;

import AJAX.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.zip.DataFormatException;

/**
 * 896
 * JSON-JS object notation
 * 概念
 * 早期:JS的对象表示法
 * {
 * "A":"a",
 * "B":""b
 * }
 * <p>
 * var p = {
 * "name":"张三",
 * "age":23,
 * "gender":"男"
 * }
 * <p>
 * 今日应用:
 * 存储和交换"文本"信息的语法.代替xml
 * <p>
 * 897
 * JSON语法:
 * 1. 基本规则
 * 引号+键值对/单双都行,也可以不使用
 * 值有哪些? 字符串"" 数字 字符串 逻辑值true/false 数组 null JSON对象
 * 逗号分隔 ,
 * 花括号保存 {}
 * 方括号保存数组 []
 * 2. 获取数据
 * 1. obj.key
 * 2. obj["key"]
 * 3. obj[i]
 * 3. JSON 和 JavaBean 相互转化
 * 以后传输就是JSON了~~
 * 1. JSON -> JavaBean
 * 2. JavaBean -> JSON
 * <p>
 * JSON解析器: Jsonlib Gson fastjson jackson--spring内置
 * <p>
 * jackson使用方法
 * 导包
 * 注解
 *
 * @ JsonIgnore
 * @ JsonFormat
 * 负责格式转换  Map{{}{}} List[{}{}]  转换
 *
 *
 *      JSON转java对象
 *      readValue(json,class)
 *
 * 用户名校验测试
 */

public class D0907JSON {
    @Test
    public void jsonTest() {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(233);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(2343);
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> personList  = new ArrayList<>();
        personList.add(p);
        personList.add(p2);
        personList.add(p3);

        Map<String ,Person> personMap  = new HashMap<>();
        personMap.put("z",p);
        personMap.put("z2",p2);
        personMap.put("z3",p3);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json =  mapper.writeValueAsString(p);
            //{"name":"张三","age":23,"gender":"男","birthday":1567861780865}
            //{"name":"张三","age":23,"gender":"男"}  @JsonIgnore
            //{"name":"张三","age":23,"gender":"男","birthday":"2019-09-07"}  @JsonFormat(pattern = "yyyy-MM-dd")
//            System.out.println(json);


//            String jsonList = mapper.writeValueAsString(personList);
//            System.out.println(jsonList);
            //[{"name":"张三","age":23,"gender":"男","birthday":"2019-09-07"},
            // {"name":"张三","age":233,"gender":"男","birthday":"2019-09-07"},
            // {"name":"张三","age":2343,"gender":"男","birthday":"2019-09-07"}]

//            String jsonMap = mapper.writeValueAsString(personMap);
//            System.out.println(jsonMap);
            //{"z2":{"name":"张三","age":233,"gender":"男","birthday":"2019-09-07"},
            // "z3":{"name":"张三","age":2343,"gender":"男","birthday":"2019-09-07"},
            // "z":{"name":"张三","age":23,"gender":"男","birthday":"2019-09-07"}}


        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            String json = "{\"name\":\"张三\",\"age\":233,\"gender\":\"男\",\"birthday\":\"2019-09-07\"}";
            final Person person = mapper.readValue(json, Person.class);
            System.out.println(person);
            //Person{name='张三', age=233, gender='男'}
            //Person{name='张三', age=233, gender='男', birthday=Sat Sep 07 08:00:00 CST 2019}
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
