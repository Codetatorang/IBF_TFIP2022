package ibf2022.sdf.day01.workshop;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public static void main(String[] args) {
        //welcome text
        System.out.println("Welcome to your shopping cart");
        
        //cart list
        List<String> cart = new ArrayList<String>();

        //get user input
        Console cons = System.console();
        
        //boolean to check for exit 
        Boolean exit = false;

        //input array 
        String input;
        String[] inputArr;

        while(!exit){
            input = cons.readLine(">");
            inputArr = input.trim().split(" ");
        }

    }
    //add method
    public void add(String item){

    }

    //list method
    public void list(List<String> cart){
        if (cart.isEmpty())
            System.out.println("Your cart is empty");
        else{
            for (int i = 0;i < cart.size(); i++) {
                System.out.printf("%d. %s\n",i,cart.get(i));
            }
        }
    }

    //delete method
    public void delete(List<String> cart){

    }

}
