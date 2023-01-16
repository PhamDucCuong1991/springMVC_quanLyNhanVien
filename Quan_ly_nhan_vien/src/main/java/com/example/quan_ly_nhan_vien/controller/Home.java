package com.example.quan_ly_nhan_vien.controller;

import com.example.quan_ly_nhan_vien.dao.EmployeeDAO;
import com.example.quan_ly_nhan_vien.model.Employee;
import com.example.quan_ly_nhan_vien.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Home {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeDAO employeeDAO;

    @GetMapping("/home")
    public String showEmployeesList(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "home";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("employees", employeeService.findListByName(name));
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        employeeService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Employee employee) {
        employeeService.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Employee employee) {
        int index = employeeService.findIndexById(employee.getEmployeeCode());
        employeeService.getAll().set(index, employee);
        employeeService.edit(employee);
        return "redirect:/home";
    }

    @GetMapping("/information")
    public String showInfor(@RequestParam int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "information";
    }

}
