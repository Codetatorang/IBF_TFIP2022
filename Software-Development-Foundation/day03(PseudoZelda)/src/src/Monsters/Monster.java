package src.Monsters;

import src.Damagable;

public class Monster implements Damagable{
    private int health = 4;

    public Monster(){}
    public Monster(int health){this.health = health;}
    public int getHealth() {return health;}
    public boolean isDead(){return health <= 0;}

    @Override
    public void hit(int damage){
        this.health -=damage;
    }

}