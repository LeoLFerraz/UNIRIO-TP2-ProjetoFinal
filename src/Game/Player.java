package Game;



public class Player extends Actor{
    Player(){}
    private int classActor = 0;
    private int luck = 0;

    public int getClassActor() {
        return classActor;
    }

    public void setClassActor(int classActor) {
        this.classActor = classActor;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
    
    public void printPlayerInformation(){
        System.out.println("Player");
        System.out.println("Name: " + getName());
        System.out.println("Class: " + getClassActor());
        System.out.println("Level: " + getLevel());
        System.out.println("HP: " + getHp());
        System.out.println("Strength: " + getStrength());
        System.out.println("Endurance: " + getEndurance());
        System.out.println("Intelligence: " + getIntelligence());
        System.out.println("Luck: " + getLuck());
        System.out.println(" -------- ");
    };
}
