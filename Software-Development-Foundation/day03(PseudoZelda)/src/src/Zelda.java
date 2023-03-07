package src;

import src.Monsters.Monster;
import src.Monsters.RockMonster;

public class Zelda {
    public static void main(String[] args){
        Monster monster = new Monster();
        Trees tree = new Trees();
        Monster rockMonster = new RockMonster();
        Link link = new Link();

        link.attack(monster);
        link.attack(rockMonster);
        link.attack(tree);

        if (monster.isDead())
            System.out.println("you win!");

    }
}