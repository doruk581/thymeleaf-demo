package com.doruks.springboot.thymeleafdemo.controller;

import com.doruks.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList;

    @PostConstruct
    private void loadData(){
        Employee employee = new Employee(1,"Leslie","Andrews","leslie@hotmail.com");
        Employee employee1 = new Employee(2,"Ali","Salih","ali@hotmail.com");
        Employee employee2 = new Employee(3,"Osman","Mavi","osman@hotmail.com");

        employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // add to the spring model
        theModel.addAttribute("employees", employeeList);

        return "list-employees";
    }

}
