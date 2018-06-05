package Game;

public class Enemy extends Actor {
    Enemy(){}
    public void printEnemyInformation(){
        System.out.println("Enemy");
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.println("HP: " + getHp());
        System.out.println(" -------- ");
    }

}
