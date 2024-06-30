package ibf2022.tfip.sdf.task02.src;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome.");
        Boolean quit = false;
        Float result = 0.0f;
        Float op1, op2;
        Console cons = System.console();

        while (!quit) {
            String input = cons.readLine("> ");
            String[] operations = input.split(" ");

            // exit programme if input is exit
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye Bye");
                quit = true;
                continue;
            }

            //if input is just last 
            if (input.equalsIgnoreCase("$last")) {
                System.out.println(result);
                continue;
            }

            try {
                //converts $last to value
                if (operations[0].equalsIgnoreCase("$last")) {
                    op1 = result;
                    op2 = Float.valueOf(operations[2]);
                } else if (operations[2].equalsIgnoreCase("$last")) {
                    op1 = Float.valueOf(operations[0]);
                    op2 = result;
                } else {
                    op1 = Float.valueOf(operations[0]);
                    op2 = Float.valueOf(operations[2]);
                }

            } catch (NumberFormatException e) {
                System.out.println("you've given a wrong expression!");
                continue;
            }

            switch (operations[1]) {
                case "+" -> {
                    result = addOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                }
                case "-" -> {
                    result = minusOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                }
                case "/" -> {
                    result = divideOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                }
                case "*" -> {
                    result = timesOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                }
                default ->
                    System.out.println("You've entered an invalid expression! " + operations[1]);
            }

        }

    }

    // operations
    public static Float addOps(Float op1, Float op2) {
        return op1 + op2;
    }

    public static Float minusOps(Float op1, Float op2) {
        return op1 - op2;
    }

    public static Float timesOps(Float op1, Float op2) {
        return op1 * op2;
    }

    public static Float divideOps(Float op1, Float op2) {
        return op1 / op2;
    }
}
