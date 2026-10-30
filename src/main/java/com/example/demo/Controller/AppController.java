
package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.Employee_Service;

@Controller
public class AppController {

    @Autowired
    private Employee_Service employeeService;

    // 1. Landing page
    @GetMapping("/")
    public String landing() {
        return "landing";
    }

    // 2. Services page
    @GetMapping("/service")
    public String service() {
        return "service";
    }

    // 3. About page
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // 4. Open Add Employee form
    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    // Save new employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {

        if (employeeService.emailExists(employee.getEmail())) {

            model.addAttribute("employee", employee);
            model.addAttribute("error",
                    "This email address is already registered. Please use another email.");

            return "addEmployee";
        }

        employeeService.addEmployee(employee);

        return "redirect:/service";
    }

    // 5. Show all employee records
    @GetMapping("/show")
    public String showEmployees(Model model) {
        model.addAttribute("employees",
                employeeService.getAllEmployees());
        return "show";
    }

    // 6. Open Update Employee page
    @GetMapping("/update")
    public String updatePage(Model model) {
        model.addAttribute("employeeFound", false);
        return "update";
    }

    // Search employee by ID
    @GetMapping("/findEmployee")
    public String findEmployee(@RequestParam("id") int id, Model model) {

        Optional<Employee> employee =
                employeeService.getEmployeeById(id);

        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("employeeFound", true);
        } else {
            model.addAttribute("employeeFound", false);
            model.addAttribute("error",
                    "Employee ID " + id + " was not found.");
        }

        return "update";
    }

    // Save updated employee
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/service";
    }

    // 7. Open Delete Employee page
    @GetMapping("/delete")
    public String deletePage() {
        return "delete";
    }

    // Search employee before deletion
    @GetMapping("/findEmployeeToDelete")
    public String findEmployeeToDelete(
            @RequestParam("id") int id, Model model) {

        Optional<Employee> employee =
                employeeService.getEmployeeById(id);

        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("employeeFound", true);
        } else {
            model.addAttribute("employeeFound", false);
            model.addAttribute("error",
                    "Employee ID " + id + " was not found.");
        }

        return "delete";
    }

    // Delete employee by ID
    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/service";
    }
}
