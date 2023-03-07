package ibf2022.tfip.sdf.src;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ShoppingCart sc = new ShoppingCart();

        // create directory if it does not exists
        String dirPath = "\\cartDB";
        File directory = new File(dirPath);

        // check if directory cartDB exists, if not create db directory instead
        if (directory.exists()) {
            System.out.println("Directory already exists.\n");
        } else {
            dirPath = "..\\db";
            File newDirectory = new File(dirPath);

            if (newDirectory.exists()) {
                System.out.printf("Directory already exists.\n");
            } else {
                newDirectory.mkdir();
                System.out.printf("Directory created at path: %s \n", newDirectory.getAbsolutePath());
            }
        }

        Console cons = System.console();
        String input = "";
        String stringLogin = "";
        System.out.println("Welcome to your Shopping Cart\n");
        while (!input.equals("exit")) {
            input = cons.readLine("What would you like to do? type 'help' to show list\n");
            String inputarr[] = input.trim().split(" ");

            switch (inputarr[0]) {
                case "help":
                    System.out.println("'list' to show a list of items in shopping cart");
                    System.out.println("login <name> to access your cart");
                    System.out.println("add <item name>");
                    System.out.println("delete <item number>");
                    System.out.println("'quit' to exit program");
                    break;
                case "login":
                    input = input.replace(",", " ");
                    Scanner scan = new Scanner(input.substring(6));
                    while (scan.hasNext()) {
                        stringLogin = scan.next();
                    }

                    File loginFile = new File(dirPath + File.separator + stringLogin);

                    // Create new file under specified directory
                    boolean isCreated = loginFile.createNewFile();
                    if (isCreated) {
                        System.out.printf("\nSuccessfully created new file, path:%s\n", loginFile.getCanonicalPath());
                    } else { // File may already exist
                        System.out.printf("\nUnable to create new file, %s already existed.\n", stringLogin);
                    }
                    break;
                case "users":
                    // Creating a File object for directory
                    File directoryPath = new File(dirPath);

                    // List of all files and directories
                    String contents[] = directoryPath.list();
                    System.out.println("List of files and directories in the specified directory:");
                    for (int i = 0; i < contents.length; i++) {
                        System.out.println(contents[i]);
                    }
                    break;
                case "add":
                    sc.add(input, dirPath, stringLogin);
                    break;
                case "delete":
                    sc.delete(input, dirPath, stringLogin);
                    break;
                case "list":
                    sc.list(dirPath, stringLogin);
                default:
                    if (inputarr[0].equalsIgnoreCase("exit")){
                        System.out.println("Ending the programme...");
                        continue;
                    }
                    System.out.println("Please enter a valid option. use 'help' to show list of options.");
            }
        }

    }

}
