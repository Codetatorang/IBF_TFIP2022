package ibf2022.tfip.sdf.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    List<String> cartItems = new ArrayList<String>();

    public void list(String dirPath, String stringLogin) throws FileNotFoundException, IOException {

        cartItems = new ArrayList<String>();

        // File path is passed as parameter
        File file = new File(dirPath + File.separator + stringLogin);

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till there is character in a string
        while (null != (st = br.readLine())) {
            // Print the string
            System.out.println(st);
            cartItems.add(st);
        }

        br.close();

        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty");
        }
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cartItems.get(i));
        }
    }

    public void add(String input, String dirPath, String stringLogin) throws IOException {
        input = input.replace(',', ' ');

        String stringVal = "";
        Scanner scan = new Scanner(input.substring(4));

        FileWriter fileWriter = new FileWriter(dirPath + File.separator + stringLogin, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        while (scan.hasNext()) {
            stringVal = scan.next();
            if (cartItems.size() > 0 && cartItems.contains(stringVal)) {
                System.out.printf("You have %s in your cart\n", stringVal);
            } else {
                cartItems.add(stringVal);
                System.out.printf("%s added to cart\n", stringVal);
                printWriter.printf("%s\n", stringVal);
            }
        }

        // flush and close writer
        printWriter.flush();
        fileWriter.flush();
        printWriter.close();
        fileWriter.close();

    }

    public void delete(String input, String dirPath, String stringLogin) throws IOException{
        String stringVal = "";
        Scanner scan = new Scanner(input.substring(6));

        while (scan.hasNext()) {
            stringVal = scan.next();

            int listItemIndex = Integer.parseInt(stringVal);

            if (listItemIndex < cartItems.size()) {
                System.out.printf("deleted %s from cart\n", cartItems.get(listItemIndex-1));
                cartItems.remove(listItemIndex-1);
            } else {
                System.out.println("Incorrect item index");
            }
        }

        FileWriter fileWriter = new FileWriter(dirPath + File.separator + stringLogin, false);
        BufferedWriter bwr = new BufferedWriter(fileWriter);

        int listCount = 0;
        while (listCount < cartItems.size()) {
            bwr.write(cartItems.get(listCount));
            bwr.newLine();
            listCount++;
        }

        bwr.flush();
        fileWriter.flush();
        bwr.close();
        fileWriter.close();
    }
}
