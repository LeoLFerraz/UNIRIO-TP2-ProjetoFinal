package corepckg;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Actor implements CastSkill {
	// Attributes:
	private static ArrayList<String> allowedNames = new ArrayList<String>(); // Populated on startGame();
	
	// Constructors:
	Enemy(String newName) { // Generates an enemy with a specified name (used primarily by FirstFloor and BossFloor - if we ever implement the latter)
		super(newName);
		this.setStr(genRandomAttribute());
		this.setEnd(genRandomAttribute());
		this.setInt(genRandomAttribute());
		this.updateMaxHp();
		this.setHp(this.getMaxHp());
	}
	Enemy() { // Generates an enemy with a random name picked from the allowedNames list.
		super(genRandomEnemyName());
		this.setStr(genRandomAttribute());
		this.setEnd(genRandomAttribute());
		this.setInt(genRandomAttribute());
		this.updateMaxHp();
		this.setHp(this.getMaxHp());
	}
	
	// Getters:
	
	// Setters:
	public static void addAllowedName(String newName) {
		Enemy.allowedNames.add(newName);
	}
	
	// Methods:
	public static String genRandomEnemyName() {
		Random rng = new Random();
		int numberOfAllowedNames = Enemy.allowedNames.size();
		return Enemy.allowedNames.get(rng.nextInt(numberOfAllowedNames));
	}
	
	public static int genRandomAttribute() { // This will generate a random int that scales with the floor number. The higher the floor, the higher
											 // the minimum value will be, and the higher the maximum value will be.
		Random rng = new Random();
		int floorMultiplier = Floor.getNumberOfFloors(); // [NEEDS REFACTORING, WORKS BUT DOES NOT ALLOW 'DOWNWARD' PLAYER MOVEMENT]
														 // This function assumes an enemy is only created on level (floor) instantiation.
														 // If this paradigm changes, the random attribute generator will no longer work.
		int baseAttribute = 10 * (int)Math.max(Math.floor(floorMultiplier/10), 1); // Every 10 levels starting on level 20, the multiplier goes up by one.
		int minimumBonus = (floorMultiplier - 1) % 10; // Minimum bonus of 0 for levels 1, 11, 21... Minimum bonus of 9 for levels 10, 20, 30...
		int maximumBonus = rng.nextInt(floorMultiplier) % 10; // Maximum bonus of 1 for levels 1, 11, 21... Maximum bonus of 0 for levels 10, 20, 30...
		// [NEEDS REWORK. As of right now, level 9 has minBonus = 8 and maxBonus (at best) = 9, totalling (base) 10 + (minBonus) 8 + (maxBonus) 9 = 27 at most.
		// While level 10 has a total of (base) 10 + (minBonus) 9 + (maxBonus) 0 = 19 at most.
		// This is fixed by the baseAttribute multiplier for levels above 20, as follows:
		// Level 19 has a total of (base) 10 + (minBonus) 8 + (maxBonus) 9 = 27.
		// Level 20 has a total of (base) 20 + (minBonus) 9 + (maxBonus) 0 = 29.
		// Suggestion: add a conditional bonus true only at %10 = 0 levels. This will also help us implement "Boss" levels without implementing the "BossEnemy"
		// specialization and "BossFloor" specialization.
		int randomAttribute = baseAttribute + minimumBonus + maximumBonus;
		return randomAttribute;
	}
	
	public static void populateAllowedNames() {
		Enemy.addAllowedName("P2 de TP2");
		Enemy.addAllowedName("Grade Horária de 2018.2");
		Enemy.addAllowedName("Código Não-Indentado");
		Enemy.addAllowedName("Kahoot da Kate");
		Enemy.addAllowedName("Prova na Sexta");
		Enemy.addAllowedName("BubbleSort de N = 1000");
		Enemy.addAllowedName("Tecladista da Skyrion");
		Enemy.addAllowedName("Prova? Hoje?");
		Enemy.addAllowedName("Método Recursivo");
		Enemy.addAllowedName("Professor de Redes 1");
		Enemy.addAllowedName("Programa em Python");
		Enemy.addAllowedName("Conta no Vermelho");
		Enemy.addAllowedName("Paralisação dos Caminhoneiros");
	}
	
	public int castSkill(int index, Actor target) {
		// Choose random skill;
		// randomSkill.cast(this, target);
		return 2;
	}
}
