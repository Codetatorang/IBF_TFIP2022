package ibf2022.tfip.ssf.day13workshopSpringBootEmployee.service;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day13workshopSpringBootEmployee.model.Employee;
import ibf2022.tfip.ssf.day13workshopSpringBootEmployee.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService() throws ParseException {
        logger.info("service class instantiated");
        //employeeRepo = new EmployeeRepo();
    }


    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Boolean add(Employee employee){
        return employeeRepo.add(employee);
    }

    public void save() throws FileNotFoundException{
        employeeRepo.save();
    }

    public Boolean update(Employee em){
        return employeeRepo.update(em);
    }

    public Employee findByEmail(String email){
        return employeeRepo.findByEmail(email);
    }

    public Boolean delete(Employee employee){
        return employeeRepo.delete(employee);
    }
}
