package src;

public class Trees implements Damagable{
    private int health = 10;

    public Trees(){}
    public Trees(int health){this.health = health;}
    public int getHealth() {
        return health;
    }
    public boolean isDead(){
        return health <= 0;
    }
    public void setHealth(int health) {this.health = health;}

    @Override
    public void hit(int damage){
        this.health -= damage;
    }
    
}