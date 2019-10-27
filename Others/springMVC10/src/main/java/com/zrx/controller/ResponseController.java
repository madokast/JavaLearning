package com.zrx.controller;

import com.zrx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/request")
public class ResponseController {

    /**
     * 返回字符串
     * 则找到 /WEB-INF/pages/ + /request + /returnString + success + .jsp
     * @return 字符串
     */
    @RequestMapping("/returnString")
    public String testReturnString(Model model){
        //<!--    配置视图解析器，才能通过return的字符串找到jsp页面-->
        //    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        //        <property name="prefix" value="/WEB-INF/pages/"/>
        //        <property name="suffix" value=".jsp"/>
        //    </bean>
        model.addAttribute("msg","testReturnString");
        return "success";
    }

    /**
     * 返回值是void类型
     * 则默认跳转到 returnVoid.jsp
     * --- /zrx/WEB-INF/pages/request/returnVoid.jsp
     */
    @RequestMapping("/returnVoid")
    public void testReturnVoid(){
        System.out.println("testReturnVoid");
    }

    @RequestMapping("/returnModelAndView")
    public ModelAndView testReturnModelAndView(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","ReturnModelAndView");
        modelAndView.setViewName("success");

        return modelAndView;
    }

    /**
     * 异步请求json
     *
     * 哇哦，自动打包到User user 从RequestBody 的json
     *
     * 哇哇哇 又自动把user ->>> json
     */
    @RequestMapping("/testAjax")
    public User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        System.out.println("user = " + user);

        user.setAge(user.getAge()*2);
        user.setName(user.getName()+user.getName());

        System.out.println("user = " + user);
        return user;

    }
}
