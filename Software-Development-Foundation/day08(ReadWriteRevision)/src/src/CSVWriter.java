package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPERATOR = "\n";

    private static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";

    // String dirPath = ".//data";
    // String fileName = "data.txt";

    public List<Employee> employees = null;

    public List<Employee> generateEmployees() {
        employees = new ArrayList<>();

        // create some employees
        Employee emp1 = new Employee(12345, "Dionne", "SS", "Advisor", "test1@gmail.com", 20000);
        Employee emp2 = new Employee(12345, "Gionne", "SS", "Advisor", "test2@gmail.com", 10000);
        Employee emp3 = new Employee(12345, "Fionne", "SS", "Advisor", "test3@gmail.com", 15000);

        //add the employees to the list of employees
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSV(List<Employee> employees, String fileName)throws IOException{
        //write FILE_HEADER to csv
        try (FileWriter fw = new FileWriter(fileName)) {
            //write FILE_HEADER to csv
            fw.append(FILE_HEADER);
            fw.append(NEWLINE_SEPERATOR);
            
            //read records ro wby row and write it to the file using fw.append()

            for (Employee e: employees) {
                fw.append(e.toString()+ '\n');
            }
            
            //flush and close the file writer
            fw.flush();
        }

    }

}