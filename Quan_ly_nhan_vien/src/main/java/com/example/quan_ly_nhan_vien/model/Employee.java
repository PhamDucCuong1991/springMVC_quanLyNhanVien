package com.example.quan_ly_nhan_vien.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    int employeeCode;
    String name;
    int age;
    double salary;
    String branch;

    public Employee() {
    }

    public Employee(int employeeCode, String name, int age, double salary, String branch) {
        this.employeeCode = employeeCode;
       this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
