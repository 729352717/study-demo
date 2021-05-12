package com.jsh.demo.pojo;

import java.util.Date;

/**
 * 员工
 */
public class Employee {

    private Integer id;
    private String employeeName;
    private String email;
    private Integer sex; // 1、男；2、女
    private Department department;
    private Date birth;

    public Employee(){
    }

    public Employee(Integer id, String employeeName, String email, Integer sex, Department department) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.birth = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
