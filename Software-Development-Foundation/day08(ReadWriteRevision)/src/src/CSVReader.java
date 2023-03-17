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
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        List<String> tempList = new ArrayList<String>();
        // read from CSV file
        while ((line = br.readLine()) != null) {
            tempList.add(line);
        }

        for (String s : tempList) {
            System.out.println(s);
        }
        fr.close();
        br.close();
    }

    public List<Employee> ReadCSV2(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        // remove the first line
        br.readLine();

        List<Employee> empList = new LinkedList<Employee>();
        while ((line = br.readLine()) != null) {
            String[] tempArray = line.split(COMMA_DELIMITER);
            Employee emp = new Employee(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], tempArray[3], tempArray[4], Integer.parseInt(tempArray[5]));

            empList.add(emp);
        }
        fr.close();
        br.close();

        //return the list of employee objects
        return empList;
    }
}