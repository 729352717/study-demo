package com.jsh.demo.dao;

import com.jsh.demo.pojo.Department;
import com.jsh.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeeMap = null;

    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001, new Employee(1001, "Jim", "jsh@aa.com", 1,
                new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "Ben", "ben@aa.com", 1,
                new Department(102, "市场部")));
        employeeMap.put(1003, new Employee(1003, "Tom", "tom@aa.com", 1,
                new Department(103, "人事部")));
        employeeMap.put(1004, new Employee(1004, "Kitty", "kitty@aa.com", 2,
                new Department(104, "研发部")));
        employeeMap.put(1005, new Employee(1005, "Alice", "alice@aa.com", 2,
                new Department(105, "销售部")));
    }

    private static Integer id = 1006;

    @Autowired
    private DepartmentDao departmentDao;

    // 新增员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(id++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    // 查询员工列表
    public Collection<Employee> getEmployees(){
        return employeeMap.values();
    }

    // 通过id获取员工
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    // 通过id删除员工
    public void  deleteEmployeeById(Integer id){
        employeeMap.remove(id);
    }
}
