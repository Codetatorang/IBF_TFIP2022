package sg.nus.edu.iss;

import java.util.Scanner;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // String[] choice = {"Scissors","Paper","Stone"};
        Integer computerChoice, playerChoice;
        String winner = "";

        try (Scanner scanner = new Scanner(System.in)) {
            SPS sps = new SPS();
            computerChoice = sps.generateComputerChoice();
            while (winner.equals("")) {
                System.out.println("Enter Scissors(1), Paper(2), or Stone(3)");
                playerChoice = scanner.nextInt();
                
                if(!(playerChoice >=1) && (playerChoice <=3)){
                    System.out.println("Invalid input: Only number 1,2 or 3 allowed.");
                    continue;
                }
                
                winner = sps.checkWinner(playerChoice,computerChoice);
                
                if(winner.equalsIgnoreCase("")){
                    System.out.println("Its a tie");
                    //winner = "-"; //break out of the loop
                }else{
                    System.out.println(winner +" wins!");
                }
            }
            //close the scanner
        }
    }

    
}
