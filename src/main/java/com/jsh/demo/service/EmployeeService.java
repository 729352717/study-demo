package com.jsh.demo.service;

import com.jsh.demo.dao.EmployeeDao;
import com.jsh.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    // 新增员工
    public void save(Employee employee){
        employeeDao.save(employee);
    }

    // 查询员工列表
    public Collection<Employee> getEmployees(){
        return employeeDao.getEmployees();
    }

    // 通过id获取员工
    public Employee getEmployeeById(Integer id){
        return employeeDao.getEmployeeById(id);
    }

    // 通过id删除员工
    public void  deleteEmployeeById(Integer id){
        employeeDao.deleteEmployeeById(id);
    }
}
