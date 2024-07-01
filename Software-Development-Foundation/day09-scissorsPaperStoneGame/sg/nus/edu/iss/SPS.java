package sg.nus.edu.iss;

import java.util.Random;

public class SPS {
    // scissors paper stone class
    public Integer generateComputerChoice() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public String checkWinner(Integer playerChoice, Integer computerChoice) {
        String winner = "";
        // player starts from with index
        playerChoice -= 1;

        if (playerChoice.equals(computerChoice)) {
            //System.out.println("Tie");
            return "";
        }

        switch (playerChoice) {
            case 0 -> {
                // scissors
                if (computerChoice == 1) {
                    winner = "player";
                } else {
                    winner = "Computer";
                }
            }
            case 1 -> {
                // paper
                if (computerChoice == 2) {
                    winner = "player";
                } else {
                    winner = "Computer";
                }
            }
            case 2 -> {
                // stone
                if (computerChoice == 0) {
                    winner = "player";
                } else {
                    winner = "Computer";
                }
            }
        }
        return winner;
    }
}
