package src;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException{
        String dirPath = ".//data";
        String fileName = "data.txt";

        File newDir = new File(dirPath);
        boolean isDirCreated = newDir.mkdir();

        if(isDirCreated){
            System.out.println("New directory " + dirPath + " created.");
        }else{
            System.out.println("Directory" + dirPath + " exists.");
        }

        File newFile = new File(dirPath + File.separator +  fileName);
        boolean isFileCreated = newFile.createNewFile();

        if(isFileCreated){
            System.out.println("New file " + fileName + " created.");
        }else{
            System.out.println("New file " + fileName + " exists.");
        }

        //list the file objects
        File fileList[] = newDir.listFiles();
        for (File file : fileList) {
            System.out.println("File " + file.getCanonicalPath() + ":" + file.getCanonicalFile() + "\n");
        }

        //write to data.txt file using fileoutputstream
        // FileOutputStream fos = new FileOutputStream(newFile,true);
        // for(int i =0; i<10; i++){
        //     char str[] = Integer.toString(i).toCharArray();

        //     fos.write(str[0]);
        //     fos.write('\n');
        // }

        // String welcomeMessage = "welcome to ISS TFIP programme";

        // //Convert string to byte[] array using getBytes()
        // byte[] outputData = welcomeMessage.getBytes();
        // fos.write(outputData);

        // fos.flush();
        // fos.close();

        String fileEmployees = "employees.txt";
        File newEmployeeFile = new File(dirPath + File.separator +  fileEmployees);
        boolean isEmployeeFileCreated = newEmployeeFile.createNewFile();

        if(isEmployeeFileCreated){
            System.out.println("New file " + fileEmployees + " created.");
        }else{
            System.out.println("New file " + fileEmployees + " exists.");
        }

        CSVWriter cw = new CSVWriter();
        List<Employee> employeeList = cw.generateEmployees();
        cw.writeToCSV(employeeList, dirPath + File.separator + fileEmployees);

        CSVReader cr = new CSVReader();
        List<Employee> empList = cr.ReadCSV2(dirPath + File.separator + fileEmployees);
        System.out.println(empList.toString());

    }
}