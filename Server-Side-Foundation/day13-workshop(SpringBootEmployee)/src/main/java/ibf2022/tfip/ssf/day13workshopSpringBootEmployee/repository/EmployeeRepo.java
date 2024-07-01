package ibf2022.tfip.ssf.day13workshopSpringBootEmployee.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day13workshopSpringBootEmployee.model.Employee;

@Repository
public class EmployeeRepo {
    //logger
    Logger logger = LoggerFactory.getLogger(EmployeeRepo.class);
    //directory path
    final String dirPath = System.getProperty("user.dir") + File.separator + "data";
    final String fileName = "employee.txt";

    private List<Employee> employees;
    
    public EmployeeRepo() throws ParseException{
        logger.info("employees created");
        if (null == employees){
            employees = new ArrayList<>();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = df.parse("1973-04-26");
        Employee em = new Employee("Ashton","Smith", "ASmith@gmail.com", "92383212", 12500,   dt, "Bishan St 23", 553421);
        employees.add(em);

        dt = df.parse("1993-04-26");
        em = new Employee("Wolonglong","Young","Younglong21@gmail.com","9724212",9992, dt,"Suntec Tower 2", 436322);
        employees.add(em);

        dt = df.parse("1973-04-26");
        em = new Employee("Pixel","Biang","BiangXpixel@gmail.com","8823642",9919, dt,"Hougang Mall", 52421);
        employees.add(em);

    }
    
    public List<Employee> findAll(){
        return employees;
    }
    
    public Boolean add(Employee employee){
        Boolean result = employees.add(employee);
        return result;
    }

    public void save() throws FileNotFoundException{
        File f = new File(dirPath + File.separator + fileName);
        OutputStream os = new FileOutputStream(f);
        try (PrintWriter pw = new PrintWriter(os)) {
            pw.println(employees.toString());
            pw.flush();
        }
    }

    public Boolean delete(Employee employee){
        Boolean result = false;
        int empIndex = employees.indexOf(employee);
        if (empIndex>=0){
            employees.remove(empIndex);
            result = true;
        }

        return result;
    }

    public Boolean update(Employee em){
        Employee emp = employees.stream().filter(e->e.getEmail().equals(em.getEmail())).findFirst().get();

        int empIndex = employees.indexOf(emp);
        if(empIndex >= 0){
            employees.remove(empIndex);
        }
        employees.add(em);
        return true;
    }

    public Employee findByEmail(String email){
        Employee emp = employees.stream().filter(e->e.getEmail().equals(email)).findFirst().get();
        logger.info("empEmail = %s".formatted(emp.getEmail()));
        return emp;
    }
}
