package com.example.thymeleaf_demo.controllers;

import com.example.thymeleaf_demo.entities.Employee;
import com.example.thymeleaf_demo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String showListOfEmployees(Model model) {
        model.addAttribute("list", service.findAllEmployees());
        return "list-employees";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        service.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = service.findEmployeeById(id);
        model.addAttribute("employee",employee);
        service.saveEmployee(employee);
        return "add-employee";
    }

}
