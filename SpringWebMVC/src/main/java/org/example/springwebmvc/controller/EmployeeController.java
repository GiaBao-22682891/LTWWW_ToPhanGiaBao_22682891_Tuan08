package org.example.springwebmvc.controller;

import org.example.springwebmvc.model.Employee;
import org.example.springwebmvc.model.enumerate.Gender;
import org.example.springwebmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public String index (Model model) {
        List<Employee> employees = employeeService.listOfEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/register")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = new Employee();
        employee.setGender(Gender.Male);
        modelAndView.setViewName("employee-register");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

//    @GetMapping("employees")
//    public ModelAndView listEmployee (Employee employee, BindingResult bindingResult) {
//        ModelAndView mav = new ModelAndView("employee-list");
//        mav.addObject("employees", employeeService.listOfEmployees());
//        return mav;
//    }

    @PostMapping("/register")
    public ModelAndView handleRegister (@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);

        ModelAndView modelAndView = new ModelAndView("employee-register");
        modelAndView.addObject("message", "Employee registered successfully!");
        Employee employee1 = new Employee();
        employee1.setGender(Gender.Male);
        modelAndView.addObject("employee", employee1); // reset the form
        return modelAndView;

    }
}
