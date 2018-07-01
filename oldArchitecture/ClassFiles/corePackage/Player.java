package corepckg;

public class Player extends Actor implements CastSkill {
	// Attributes:
	private final PlayerClass playerClass;
	private int luck;
	
	// Constructors:
	Player(String newName, PlayerClass newPlayerClass){
		super(newName);
		this.playerClass = newPlayerClass;
		this.setStr(this.playerClass.getBaseStr());
		this.setEnd(this.playerClass.getBaseEnd());
		this.setInt(this.playerClass.getBaseInt());
		this.setLuck(this.playerClass.getBaseLuck());
		this.updateMaxHp();
	}
	
	// Getters:
	public PlayerClass getPlayerClass() {
		return this.playerClass;
	}
	
	public int luck() {
		return this.luck;
	}
	
	// Setters:
	public void setLuck(int newLuck) {
		// [need validations]
		this.luck = newLuck;
	}
	
	// Methods:
}
