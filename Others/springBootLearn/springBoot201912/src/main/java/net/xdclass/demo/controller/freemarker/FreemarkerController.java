package net.xdclass.demo.controller.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBean;

/**
 * Description
 * FreemarkerController
 * <p>
 * Data
 * 2019/12/18 22:34
 *
 * @author zrx
 * @version 1.0
 */

@Controller
public class FreemarkerController {

    @GetMapping("/myfreemarker")
    @ResponseBody
    public String myfreemarker(ModelMap modelMap){

        return "hello.ftl";
    }
}
