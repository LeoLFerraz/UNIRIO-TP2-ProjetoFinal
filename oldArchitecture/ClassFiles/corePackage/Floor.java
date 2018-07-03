package corepckg;
import java.util.ArrayList;

public class Floor {
	// Attributes:
	private static ArrayList<Floor> floorList = new ArrayList<Floor>();
	private final Enemy enemy;
	
	// Constructors:
	Floor() {
		if(Floor.getNumberOfFloors() == 0) {
			Floor.addFloor(this); // Make sure the floor adds itself to the static list of floors before anything else is done by the constructor.
								  // The Enemy class uses the static list to determine the random seed with which attributes will be generated.
			this.enemy = new Enemy("Training Dummy");
		}
		else {
			Floor.addFloor(this);
			this.enemy = new Enemy();
		}
	}
	
	// Getters:
	public static Floor getFloorByIndex(int index) {
		return Floor.floorList.get(index);
	}
	
	public static int getNumberOfFloors() {
		return Floor.floorList.size();
	}
	
	public Enemy getEnemy() {
		return this.enemy;
	}
	
	// Setters:
	public static void addFloor(Floor newFloor) {
		Floor.floorList.add(newFloor);
	}
	
	// Methods:
		// Enemy access shortcuts:
	public String getEnemyName() {
		return this.enemy.getName();
	}
	public int getEnemyCurrentHp() {
		return this.enemy.getCurHp();
	}
	public int getEnemyMaxHp() {
		return this.enemy.getCurHp();
	}
}
