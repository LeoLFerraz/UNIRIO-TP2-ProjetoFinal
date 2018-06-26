package Game;

	import java.util.ArrayList;


	public abstract class Actor {
	    Actor(){
	    }
	    private String name = null;
	    private int hp = 0;
	    private int strength = 0;
	    private int endurance = 0;
	    private int intelligence = 0;
	    private int level = 0; 
	    private ArrayList<Skill> skillSet = new ArrayList(); 

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getHp() {
	        return hp;
	    }

	    public void setHp(int hp) {
	        this.hp = hp;
	    }

	    public int getStrength() {
	        return strength;
	    }

	    public void setStrength(int strength) {
	        this.strength = strength;
	    }

	    public int getEndurance() {
	        return endurance;
	    }

	    public void setEndurance(int endurance) {
	        this.endurance = endurance;
	    }

	    public int getIntelligence() {
	        return intelligence;
	    }

	    public void setIntelligence(int intelligence) {
	        this.intelligence = intelligence;
	    }
	    
	    public int getLevel() {
	        return level;
	    }

	    public void setLevel(int level) {
	        this.level = level;
	    }
	    
	    public ArrayList<Skill> getSkillSet() {
	        return skillSet;
	    }

	    public void setSkillSet(ArrayList<Skill> skills) {
	       this.skillSet = skills;
	    }

	}

