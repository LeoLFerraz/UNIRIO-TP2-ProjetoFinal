package corepckg;
import java.util.ArrayList;

public class Floor {
	// Attributes:
	private static ArrayList<Floor> floorList;
	
	// Constructors:
	
	// Getters:
	public static Floor getFloorByIndex(int index) {
		return Floor.floorList.get(index);
	}
	
	public static int getNumberOfFloors() {
		return Floor.floorList.size();
	}
	
	// Setters:
	public static void addFloor(Floor newFloor) {
		Floor.floorList.add(newFloor);
	}
	
	// Methods:

}
