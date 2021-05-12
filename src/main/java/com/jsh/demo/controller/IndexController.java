package com.jsh.demo.controller;

import com.jsh.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class IndexController {

    @RequestMapping("/in")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session){
        String msg = "";
        if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            msg = "登录名或密码不能为空！";
        }else if("111".equals(password)){
            // 塞入登录session
            session.setAttribute("loginUser", username);
            return "redirect:/emp/employee_list.html";
        } else{
            msg = "登录名或密码错误！";
        }
        model.addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping("/out")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }


}
