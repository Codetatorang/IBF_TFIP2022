package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatInTheHat {
    //input/output stream method

    // public static void main(String[]args) throws FileNotFoundException{
    // public static void main(String[]args){
    // //Read the file the chat_in_the_hat(cith)
    // Path cithPath = Paths.get("../data/cat-in-the-hat.txt");
    // File cith = cithPath.toFile();
    // try{
    // //open a file
    // InputStream is = new FileInputStream(cith);
    // OutputStream os = new FileOutputStream("copy_of_cat_in_the_hat.txt");
    // byte[] buffer = new byte[2048]; // 1/2k buffer

    // int size;
    // //size >0 when not EOF size == -1 at EOF
    // while ((size = is.read(buffer)) >=0){
    // System.out.printf("size %d\n", size);
    // os.write(buffer,0,size);
    // }

    // //close the input stream
    // is.close();
    // //close the output stream
    // os.flush();
    // os.close();

    // } catch (IOException ex){
    // System.err.printf(">>>IO exception: %s\n", ex.getMessage());
    // ex.printStackTrace();
    // }
    // }

    // Read the file the_cat_in_the_hat
    public static void main(String[] args) throws IOException {
        // Read the file the chat_in_the_hat
        Path cithPath = Paths.get("../data/cat-in-the-hat.txt");
        File cith = cithPath.toFile();

        if (!cith.exists()) {
            System.err.println("cannot find file");
            System.exit(1);
        }

        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);

        FileWriter writer = new FileWriter("../data/CAPS-CAT-IN-THE-HAT.txt");
        String line;

        while (null != (line = br.readLine())) {
            writer.write(line.toUpperCase());
            writer.write("\n");
        }

        System.out.println("write to file completed.");

        // close the reader
        br.close();
        fr.close();

        // close the writer
        writer.flush();
        writer.close();
    }
}