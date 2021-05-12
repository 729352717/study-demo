package com.jsh.demo.service;

import com.jsh.demo.dao.DepartmentDao;
import com.jsh.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    // 获取所有部门信息
    public Collection<Department> getDepartments(){
        return departmentDao.getDepartments();
    }

    // 通过id获取部门
    public Department getDepartmentById(Integer id){
        return departmentDao.getDepartmentById(id);
    }
}
