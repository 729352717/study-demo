package com.jsh.demo.controller;

import com.jsh.demo.common.DateUtils;
import com.jsh.demo.dto.EmployeeDto;
import com.jsh.demo.pojo.Department;
import com.jsh.demo.pojo.Employee;
import com.jsh.demo.service.DepartmentService;
import com.jsh.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/page")
    public String page(){
        return "emp/employee_list.html";
    }

    @GetMapping("/add")
    public String page(Model model){
        model.addAttribute("departments", departmentService.getDepartments());
        return "emp/employee_form.html";
    }

    @GetMapping("/list")
    @ResponseBody
    public Collection<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/editShow")
    public String editShow(Integer id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("departments", departmentService.getDepartments());
        return "emp/employee_form.html";
    }

    @PostMapping("/save")
    public String save(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setEmail(employeeDto.getEmail());
        employee.setBirth(DateUtils.parseDate(employeeDto.getBirth()));
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setDepartment(new Department(employeeDto.getDepartmentId()));
        employee.setSex(employeeDto.getSex());
        employeeService.save(employee);
        return "redirect:/emp/employee_list.html";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        employeeService.deleteEmployeeById(id);
        return "emp/employee_list.html";
    }
}
