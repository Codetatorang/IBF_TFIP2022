package src.Monsters;


public class RockMonster extends Monster{
    private int health = 10;

    public RockMonster(){}
    public RockMonster(int health){this.health = health;}
    public int getHealth() {return health;}
    public boolean isDead(){return health <= 0;}

    @Override
    public void hit(int damage){
        this.health -=damage;
    }
    
    
}