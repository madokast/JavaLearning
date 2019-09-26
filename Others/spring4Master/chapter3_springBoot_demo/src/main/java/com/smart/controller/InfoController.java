package com.smart.controller;

import com.smart.domain.Info;
import com.smart.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InfoController {
    private InfoService infoService;

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping(value = {"/","index.html"})
    public ModelAndView infoPage(HttpServletRequest request){
        final Info info = infoService.getInfo();
        request.getSession().setAttribute("info",info);
        return new ModelAndView("info");
    }
}
