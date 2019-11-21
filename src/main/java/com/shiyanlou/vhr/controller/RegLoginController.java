package com.shiyanlou.vhr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重定向页面到登录页
 */
@Controller
public class RegLoginController {

    @RequestMapping("/login_p")
    public String login(){
        return "redirect:index.html";
    }

}
