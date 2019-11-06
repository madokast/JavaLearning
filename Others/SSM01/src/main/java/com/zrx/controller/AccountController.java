package com.zrx.controller;

import com.zrx.domain.Account;
import com.zrx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("AccountController:findAll");
        final List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts.toString());

        return "success";
    }

    @RequestMapping("/saveAccount")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response)
    throws Exception
    {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
