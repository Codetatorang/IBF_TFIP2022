package ibf2022.tfip.sdf.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class ReaderWriter {

    private FileReader reader;
    BufferedReader bufferReader;
    FileWriter writer;
    // Path path;
    String dirPath;

    public ReaderWriter() {
        // create directory if it does not exists
        dirPath = "\\cartDB";
        File directory = new File(dirPath);

        // check if directory cartDB exists, if not create db directory instead
        if (directory.exists()) {
            System.out.println("Directory already exists.");
        } else {
            dirPath = "..\\db";
            File newDirectory = new File(dirPath);

            if (newDirectory.exists()) {
                System.out.printf("Directory already exists.");
            } else {
                newDirectory.mkdir();
                System.out.printf("Directory created at path: %s \n", newDirectory.getAbsolutePath());
            }
        }
    }

    // public ReaderWriter(String path) throws FileNotFoundException {
    // this.path = Paths.get(path);
    // }
    public int getCartCount(String path) {
        return new File(path).listFiles().length;
    }

    // public boolean checkExistence(String name) throws IOException {
    // File fileChecker = new File(String.format("/cartDB/%s.cart", name));
    // fileChecker.createNewFile();
    // if (fileChecker.exists()) {
    // return true;
    // }
    // return false;
    // }
    public void createFile(String fileName) throws IOException {
        try {
            writer = new FileWriter(String.format("%s" + File.separator + "%s", dirPath, fileName));
        } catch (IOException e) {
            throw e;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public void readFile(String name) throws FileNotFoundException, IOException {
        try {
            File file = Paths.get(String.format("%s/%s.cart",
                    dirPath, name)).toFile();
            this.reader = new FileReader(file);
            this.bufferReader = new BufferedReader(reader);

        } catch (FileNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }

    }

    // public String bufferedFile() throws IOException {
    // return this.bufferReader.readLine();
    // }
    // public FileWriter fileWriter(String name) throws IOException {
    // return new FileWriter(
    // Constants.SHOPPINGCART +
    // String.format("%s.cart", name),
    // false);
    // }
    // public void closeBuffer() throws IOException {
    // this.bufferReader.close();
    // }
    // public void closeReader() throws IOException {
    // this.reader.close();
    // }
}
