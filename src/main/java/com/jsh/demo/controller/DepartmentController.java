package com.jsh.demo.controller;

import com.jsh.demo.pojo.Department;
import com.jsh.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/page")
    public String page(){
        return "department/department_list.html";
    }

    @GetMapping("list")
    @ResponseBody
    public Collection<Department> getDepartments(){
        return departmentService.getDepartments();
    }

}
