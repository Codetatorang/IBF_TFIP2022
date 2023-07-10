package ibf2022.tfip.ssf.day13workshopSpringBootEmployee.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.ssf.day13workshopSpringBootEmployee.model.Employee;
import ibf2022.tfip.ssf.day13workshopSpringBootEmployee.service.EmployeeService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeSvc;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/home")
    public String employeeListPage(Model model) {
        List<Employee> empList = employeeSvc.findAll();
        
        //logger.info("list size %d".formatted(empList.size()));
        model.addAttribute("employees", empList);
        return "listemployees"; 
    }

    @GetMapping("/addemployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult result, Model model) throws FileNotFoundException{
        if(result.hasErrors())
            return "addemployee";
        employeeSvc.add(employeeForm);
        return "redirect:/employees/home";
    }

    @GetMapping("/updateemployee/{email}")
    public String updateEmployee(@PathVariable String email, Model model){
        Employee employee = employeeSvc.findByEmail(email);
        model.addAttribute("employee",employee);
        return "updateemployee";
    }

    @PostMapping("/updateemployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employeeForm, BindingResult result, Model model) throws FileNotFoundException{
        if(result.hasErrors())
            return "updateemployee";
        employeeSvc.update(employeeForm);
        employeeSvc.save();
        return "redirect:/employees/home";
    }

    @GetMapping("/deleteemployee/{email}")
    public String deleteEmployee(@PathVariable String email, Model model) throws FileNotFoundException{
        Employee employee = employeeSvc.findByEmail(email);
        employeeSvc.delete(employee);
        employeeSvc.save();
        model.addAttribute("employee",employee);
        return "redirect:/employees/home";
    }
}
