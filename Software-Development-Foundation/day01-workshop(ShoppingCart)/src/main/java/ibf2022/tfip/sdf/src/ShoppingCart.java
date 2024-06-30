package ibf2022.tfip.sdf.src;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {
        List<String> cartItems = new ArrayList<>();

        // message
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();
        // boolean to check if exited
        Boolean exit = false;

        while (!exit) {
            // reads input and store as a string
            String inputString = cons.readLine(">");
            // transform input into array
            String inputArr[] = inputString.toLowerCase().trim().split(" ");

            switch (inputArr[0]) {
                case "list" -> {
                    if (cartItems.isEmpty()) {
                        System.out.println("Your cart is empty");
                        break;
                    }

                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, cartItems.get(i));
                    }
                }
                case "add" -> {
                    if (inputArr.length < 2) {
                        System.out.println("Please specify something to add");
                        continue;
                    }
                    for (int i = 1; i < inputArr.length; i++) {
                        if (!cartItems.isEmpty() && cartItems.contains(inputArr[i])) {
                            System.out.printf("You have %s in your cart\n", inputArr[i]);
                            continue;
                        }
                        cartItems.add(inputArr[i]);
                        System.out.printf("%s added to cart\n", inputArr[i]);
                    }
                }
                case "delete" -> {
                    if (inputArr.length < 2) {
                        System.out.println("Please specify an index to delete\n");
                        continue;
                    }
                    try{
                        Integer index = Integer.valueOf(inputArr[1]);
                        if (index > cartItems.size()) {
                            System.out.println("Number not in list\n");
                            break;
                        }
                        System.out.printf("%s removed from cart\n", cartItems.get(index - 1));
                        cartItems.remove(index - 1);
                    }catch(NumberFormatException ex){
                        System.out.println("Please enter the index instead of the word");
                        continue;
                    }
                }
                case "exit" -> {
                    System.out.println("exiting from programme");
                    exit = true;
                }
                default -> System.out.println("Please enter either 'list', 'add' , 'delete' or 'exit");
            }
        }

    }
}
