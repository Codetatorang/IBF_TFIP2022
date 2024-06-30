package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {
    public static final String COMMA_DELIMITER = ",";

    public void ReadCSV(String fileName) throws IOException {
        BufferedReader br;
        try (FileReader fr = new FileReader(fileName)) {
            br = new BufferedReader(fr);
            String line;
            List<String> tempList = new ArrayList<>();
            // read from CSV file
            while ((line = br.readLine()) != null) {
                tempList.add(line);
            }   for (String s : tempList) {
                System.out.println(s);
            }
        }
        br.close();
    }

    public List<Employee> ReadCSV2(String fileName) throws IOException {
        BufferedReader br;
        List<Employee> empList;
        try (FileReader fr = new FileReader(fileName)) {
            br = new BufferedReader(fr);
            String line;
            // remove the first line
            br.readLine();
            empList = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] tempArray = line.split(COMMA_DELIMITER);
                Employee emp = new Employee(Integer.valueOf(tempArray[0]), tempArray[1], tempArray[2], tempArray[3], tempArray[4], Integer.valueOf(tempArray[5]));
                
                empList.add(emp);
            }
        }
        br.close();

        //return the list of employee objects
        return empList;
    }
}