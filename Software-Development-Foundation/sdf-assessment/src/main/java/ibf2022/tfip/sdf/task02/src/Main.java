package ibf2022.tfip.sdf.task02.src;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome.");
        Boolean quit = false;
        Float result;
        Float lastResult = 0.f;
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

            if (operations[0].equalsIgnoreCase("$last")) {
                op1 = lastResult;
            } else if (operations[2].equalsIgnoreCase("$last")) {
                op2 = lastResult;
            }

            try {
                op1 = Float.parseFloat(operations[0]);
                op2 = Float.parseFloat(operations[2]);

            } catch (NumberFormatException e) {
                System.out.println("you've given a wrong expression!");
                continue;
            }

            switch (operations[1]) {
                case "+":
                    result = addOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                    break;
                case "-":
                    minusOps(op1, op2);
                    result = addOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                    break;
                case "/":
                    divideOps(op1, op2);
                    result = addOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                    break;
                case "*":
                    timesOps(op1, op2);
                    result = addOps(op1, op2);
                    if (result % 1 == 0) {
                        System.out.println(Math.round(result));
                    } else {
                        System.out.printf("%.2f\n", result);
                    }
                    break;
                default:
                    System.out.println("You've entereed an invalid expression!");
                    break;
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
