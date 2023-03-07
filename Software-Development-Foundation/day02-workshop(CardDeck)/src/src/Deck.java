package src;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new LinkedList<>();
        for (int i = 0; i< Constants.SUIT.length; i++){
            String suit = Constants.SUIT[i];
            for(int j=0;j<Constants.VALUES.length;j++){
                Integer value = Constants.VALUES[j];
                String name = Constants.NAMES[j];
                Card card = new Card(suit, value, name);
                deck.add(card);
            };
        }
        System.out.println("The new deck");
        System.out.println(deck);
    }

    Random rand = new SecureRandom();
    public void shuffle(){
        for(int current = 0; current< deck.size(); current++){
            int toSwap = rand.nextInt(deck.size());
            Card c = deck.get(current);
            Card d = deck.get(toSwap);
            deck.set(current, d);
            deck.set(toSwap,c);
        }
    }
    @Override
    public String toString() {
        return "Deck [deck=" + deck + "]";
    }
    
}