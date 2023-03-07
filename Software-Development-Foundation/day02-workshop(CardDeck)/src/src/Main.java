package src;

public class Main {
    public static void main(String[] args){
        //creates new deck object
        Deck deck = new Deck();
        System.out.printf(">> before: %s\n", deck);
        //shuffles the deck
        deck.shuffle();
        System.out.println();
        System.out.printf(">> after : %s\n", deck);

    }
}