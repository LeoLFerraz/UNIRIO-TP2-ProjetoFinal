package corepckg;
import java.util.ArrayList;

public class Enemy extends Actor implements CastSkill {
	// Attributes:
	private static ArrayList<String> allowedNames = new ArrayList<String> // Populated on startGame();
	
	// Constructors:
	Enemy(new String(genRandomEnemyName())) {
		super(newName);
	}
	
	// Getters:
	
	// Setters:
	
	// Methods:
	public static String genRandomEnemyName() {
		
	}
}
