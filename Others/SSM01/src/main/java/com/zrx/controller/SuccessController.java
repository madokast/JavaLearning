package com.zrx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "success")
public class SuccessController {

    @RequestMapping(path = "/test")
    public String success(){
        return "success";
    }

}
