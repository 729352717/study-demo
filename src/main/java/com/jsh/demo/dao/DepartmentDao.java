package com.jsh.demo.dao;

import com.jsh.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "人事部"));
        departmentMap.put(104, new Department(104, "研发部"));
        departmentMap.put(105, new Department(105, "销售部"));
    }

    // 获取所有部门信息
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    // 通过id获取部门
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }

}
