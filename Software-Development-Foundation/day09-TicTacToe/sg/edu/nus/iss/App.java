package sg.edu.nus.iss;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {

    public static void main(String[] args) {
        String[] tttBoard = new String[9];

        //player x and o
        String player, winner;
        Integer input;
        player = "X";
        winner = "";

        //fill up the board
        for(int i=0;i<9;i++){
            tttBoard[i] = String.valueOf(i+1);
        }

        TicTacToe ttt = new TicTacToe();
        
        System.out.println("\nTic-Tac-Toe game");
        System.out.println("-----------------");
        System.out.println("X will play first\n");
        
        //print initial board
        ttt.printBoard(tttBoard);

        try (Scanner scanner = new Scanner(System.in)) {
            while("".equals(winner)){
                System.out.println("Player: " + player + "'s turn.\n");
                //play tic toc logic here
                input = scanner.nextInt();
                
                //only accept keyboard input 1 to 9
                if((input > 0) && (input < 10)){
                    
                }else{
                    System.out.println("Invalid input: Only number 1 to 9 is allowed.");
                    continue;
                }
                
                //detect the next player turn
                if(tttBoard[input-1].equals(String.valueOf(input))){
                    tttBoard[input-1] = player;
                    
                    //switch player to another person's turn
                    if(player.equalsIgnoreCase("X")){
                        player = "O";
                    } else{
                        player = "X";
                    }
                    
                }else{
                    System.out.println("Position already taken up, Please enter another position.");
                }
                
                
                ttt.printBoard(tttBoard);
                winner = ttt.checkWinner(tttBoard);
                
                if(player.equalsIgnoreCase("draw")){
                    System.out.println("Its a " + winner);
                } else{
                    System.out.println("The winner of this game is " + winner);
                }
            }
        }
    }
}
