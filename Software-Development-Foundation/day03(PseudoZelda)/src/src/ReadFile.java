package src;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[]args){
        Path cithPath = Paths.get(args[0]); 
        System.out.printf("filename %s\n", cithPath);  

        File cith = cithPath.toFile();

        System.out.printf("is directory path: %b \n", cith.isDirectory());
        System.out.printf("is file: %b \n", cith.isFile());

        if (cith.isDirectory()){
            //for-each loop
            for (File file: cith.listFiles()){
                System.out.printf("\t%s (%d)\n", file.getAbsolutePath(), file.length());
            }
        }
        else{
            System.out.printf("length is: %d \n", cith.length());
            System.out.printf("absoulute path is: %s \n", cith.getAbsolutePath());
        }
    }
    
}