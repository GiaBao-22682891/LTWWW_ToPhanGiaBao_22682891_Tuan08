package org.example.springwebmvc.controller;

import org.example.springwebmvc.model.Employee;
import org.example.springwebmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee-register");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @GetMapping("employees")
    public ModelAndView listEmployee (Employee employee, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("employee-list");
        mav.addObject("employees", employeeService.listOfEmployees());
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView handleRegister (@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);

        ModelAndView modelAndView = new ModelAndView("employee_register.jsp");
        modelAndView.addObject("message", "Employee registered successfully!");
        modelAndView.addObject("employee", new Employee()); // reset the form
        return modelAndView;

    }
}
