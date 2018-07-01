package corepckg;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class GameDirector {
	// This is an abstract, "static" class. All of its methods and attributes are static and it is not meant to be instantiated.
	// The GameDirector is responsible for:
	// * Managing the game loop;
	// * Handling user input;
	// * Handling system output;
	// * Handling interaction between the system's elements.
	// For that, the GameDirector can be thought of as a Data Bus and a DSL.
	// This allows for:
	// * A lesser degree of coupling between classes (ideally none) - meaning we can develop bigger changes with lower maintenance costs;
	// * Some system scalability - as new mechanics could be added being coupled only to the GameDirector;
	// * Better system maintainability - as we can have each third of the group specialize on their own classes, rather than necessarily
	// understand each minute of the entire system.
	
	// Attributes:
	private static int gameInterface = 0; // Used to determine how user input and output will be handled;
									  // 0 = Terminal Interface
									  // 1 = GUI Interface
	
	//private static int gameState; // Used for the Event-based Architecture. Not yet implemented.
									// Used as an intermediary for handling user input and system output;
								    // [gameState system must be refactored to refer to an ENUM obj with possible values]
								    // [Once refactored, check setters validations]
								    // gameState is meant to be used as an auxiliary for the gameEvents queue;
	//private static ArrayList<gameEvent> gameEvents; // Used for the Event-based Architecture. Not yet implemented.
													  // The gameEvents queue is consumed using the GameDirector as a Data Bus. Each message is directed
													  // to the appropriate Class which, in turn, consumes it. Examples are: Player object uses the castSkill
													  // method, which generates a gameEvent message containing the castSkill parameters and the Player
													  // object (caller).
															
	private static final Scanner userInput = new Scanner(System.in); // Used for handling user input;
	
	private static Player player; // The Player reference in GameDirector SHOULD be final,
								  // but we can only set final variables in their initialization or in the constructor, and
								  // "player" is only initialized later into the game;
								  // We have two possible solutions: declare the attribute as non-final private and have
								  // no setters for it (which is viable for our project), or declare it as final and have it's
								  // handled instead of calling another constructor when we'd originally do so (which is not
								  // not viable as Actor and Player both have final attributes themselves).
								  // We opt for the first solution.
								  
	
	// Getters:
	/*public static int getGameState() { // Used for the Event-based Architecture. Not yet implemented.
		return GameDirector.gameState;
	}*/
	
	public static Player getPlayer() {
		return GameDirector.player;
	}
	
	public static int getGameInterface() {
		return GameDirector.gameInterface;
	}
	
	// Setters:
	/*public static void setGameState(int newGS) { // Used for the Event-based Architecture. Not yet implemented.
	// [recheck validations once GS system is refactored to use ENUM]
		if (newGS < 0) {
			// [THROW EXCEPTION: INVALID GAME STATE PARAMETER DETECTED]
			System.out.println("Invalid game state. Aborting.");
		}
		else {
			GameDirector.gameState = newGS;
		}
	}*/
	
	// Methods:
	
		// Output Handling Methods: // These methods are meant to provide shorthands for the text interface and as fallback in case Lanterna is not available;	
	public static void say(String string) {// Prints and breaks line. Later on, we can use this function to stylize the output text.
		System.out.println(string);
	}
	
	public static void sayil(String string) { // Prints inline;
		System.out.print(string);
	}
	
	public static void sayil(int anyParam, String string, int anotherParam) { // Prints inline with a space before the string starts and after it ends;
		System.out.print(" " + string + " ");
	}
	
	public static void sayil(String string, int anyParam) { // Prints inline with a space after the string ends;
		System.out.print(string + " ");
	}
	
	public static void sayil(int anyParam, String string) { // Prints inline with a space before the string starts;
		System.out.print(" " + string);
	}
	
	public static void waitSeconds(double seconds) { // Pauses the thread for the specified ammount of time 
													 // (jesus christ am I affraid of using the Thread object
													 // somebody give me a better function for this).
		long secondsToMiliseconds = Math.round(seconds * 1000); // Need to cast double to long because .sleep only takes int/long types.
		try { Thread.sleep(secondsToMiliseconds); } catch(Exception e) {}
	}
	
	public static void clearTerminal() { // Only simulates the clearance, as most IDE's do not support erasure.
		for (int i = 0; i < 50; i++) {
			say(" ");
		}
	}
 
	public static void printCurrentFloor() {
		// [Check for gameState once refactoring is done]
		GameDirector.say("Floor " + Floor.getNumberOfFloors());
	}
	
		// Input Handling Methods:
	public static void waitEnterKey() { // Ideally, this would be "waitAnyKey()", but it's overly complicated to do in Java and definitely not worth it.
		try { System.in.read(); } catch(Exception e) {}
		userInput.nextLine(); // Need to move the Scanner buffer one /n forward after pressing Enter;
	}
	
	public static String waitString() {
		// [needs exception handling that asks for the input again with a generic message]
		return userInput.nextLine();
	}
	
	public static int waitInt() {
		// No treatment needed here. This is a composed function only.
		// [Maybe refeactor this to parse nextLine() to int], as if the player inputs more than one character at a nextInt(), the buffer will
		// move only one space per nextInt() call, generating unnecessary errors and confusing the user.
		return userInput.nextInt();
	}
	
	public static int waitInt(int errorCode, int... allowedValues) { // returns errorCode if the provided value is not within allowedVallues
		// [Maybe refeactor this to parse nextLine() to int], as if the player inputs more than one character at a nextInt(), the buffer will
		// move only one space per nextInt() call, generating unnecessary errors and confusing the user.
		int inputValue = waitInt();
		for(int value : allowedValues)
			if (value == inputValue) {
				return inputValue;
			}
		// No treatment needed here. This is a composed function only. Treat the caller for exceptions.
		return errorCode;
	}
	
		// Game Event Handling Methods:
	public static void startGame() {
		// populating variables...
		Enemy.populateAllowedNames();
		if (GameDirector.getGameInterface() == 0) {
			startTerminalGame();
		}
		else {
			startGUIGame();
		}
	}
	
	private static void startGUIGame() { // Starts the game in Lanterna 2.0's text-based GUI.
		
	}
	
	private static void startTerminalGame() { // Starts the game in the IDE's console interface.
		GameDirector.say("Loading textures...");
		GameDirector.waitSeconds(2);
		GameDirector.say("Unpacking models...");
		GameDirector.waitSeconds(2);
		GameDirector.sayil("Oh wait... "); GameDirector.waitSeconds(0.8); GameDirector.say("there aren't any. This is a text-based game!");
		GameDirector.waitSeconds(2.5);
		GameDirector.clearTerminal();
		GameDirector.say("Welcome to the game!");
		GameDirector.say("Press Enter to continue.");
		GameDirector.waitEnterKey();
		GameDirector.say("Starting game in 3...");
		GameDirector.waitSeconds(1);
		GameDirector.say("Starting game in 2...");
		waitSeconds(1);
		GameDirector.say("Starting game in 1...");
		GameDirector.waitSeconds(1);
		GameDirector.goToNewGameScreen(); // [Must be refactored to use gameState]
	}
	
	private static void goToNewGameScreen() {
		String playerName;
		PlayerClass playerClass;
		while(true) { // [atomicize the following block as "renderPlayerNameInputInterface" and adapt goToNewGameScreen to use it.]
			try {
				clearTerminal();
				GameDirector.say("Please, type your desired nickname");
				playerName = GameDirector.waitString();
				break;
			} catch(Exception e) {
				GameDirector.say("Invalid input. Please, choose a valid nickname.");
				GameDirector.say("Taking you back to the previous screen...");
				GameDirector.waitSeconds(2);
				// [maybe insert max attempts?]
			}
		}
		while(true) { // [atomicize the following block as "renderPlayerClassInputInterface" and adapt goToNewGameScreen to use it.]
			try {
				GameDirector.say("Choose your class:");
				GameDirector.say("1 - Warrior: A sturdy, honored fighter that overcomes his foes with use of brute force. Not very smart, though.");
				GameDirector.say("2 - Ranger: Balanced fighter raised in the mystic wilds.");
				GameDirector.say("3 - Mage: An old scholar that specialized in channeling the destructive power of the arcane.");
				GameDirector.say("4 - Thief: An agile burglar that doesn't know what 'luck of the draw' means.");
				playerClass = PlayerClass.getClassByClassCode(GameDirector.waitInt(-1,1,2,3,4));
				GameDirector.player = new Player(playerName, playerClass);
				GameDirector.waitSeconds(0.5);
				GameDirector.say("You are: "+ GameDirector.getPlayer().getName() + ", the " + GameDirector.getPlayer().getPlayerClass().getClassName());
				GameDirector.waitSeconds(0.5);
				GameDirector.say("Transporting you to the arena in");
				GameDirector.waitSeconds(0.2);
				GameDirector.say("3...");
				GameDirector.waitSeconds(1);
				GameDirector.say("2...");
				GameDirector.waitSeconds(1);
				GameDirector.say("1...");
				GameDirector.waitSeconds(1);
				break;
			} catch(Exception e) {
				GameDirector.say("Invalid input. Please type the chosen class number (e.g.: 1 for Warrior).");
				GameDirector.say("Taking you back to the previous screen...");
				GameDirector.waitSeconds(3);
				// [maybe insert max attempts?]
			}
		}
		GameDirector.startMatch(); // [Must be refactored to use gameState]
	}
	
	private static void startMatch() {
		GameDirector.clearTerminal();
		// Write some introduction here;
		// And now, starting the game loop:
		boolean playerWins;
		do {
			playerWins = GameDirector.nextFloor();
		} while (playerWins);
	}
	
	private static boolean nextFloor() { // True for player wins, false for player loses
		// instantiate floor
		// print floor information
		// print 'enemy has appeared'
		// execute battle
		GameDirector.clearTerminal();
		Floor currentFloor = new Floor();
		String currentEnemyName = currentFloor.getEnemyName();
		GameDirector.say("The stairs take you to Floor #" + Floor.getNumberOfFloors());
		GameDirector.waitSeconds(1);
		GameDirector.sayil("Waiting there, at the very center of the room is a... ");
		GameDirector.waitSeconds(0.7);
		GameDirector.say(currentEnemyName);
		GameDirector.say("Starting battle...");
		boolean playerWins = GameDirector.executeBattle(currentFloor);
		if (playerWins) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static boolean executeBattle(Floor currentFloor) { // True for player wins, false for player loses;
		// Turn 1:
	// print player name and health
	// print enemy name and health
	// print player's options
	// execute player's choice.
	// print damage dealt or healed by player's choice.
	// endTurn(); <-- Checks if either are dead.
		// Turn 2:
	// print player name and health
	// print enemy name and health
	// print 'enemy's turn to act' and delay.
	// execute enemy's turn.
	// print damage dealt or healed by the enemy.
	// endTurn();
		String enemyName = currentFloor.getEnemyName();
		int enemyCurrentHp = currentFloor.getEnemyCurrentHp();
		int enemyMaxHp = currentFloor.getEnemyMaxHp();
		String playerName = GameDirector.getPlayer().getName();
		int playerCurrentHp = GameDirector.getPlayer().getCurHp();
		int playerMaxHp = GameDirector.getPlayer().getMaxHp();
		GameDirector.say(playerName + ": " + playerCurrentHp + "/" + playerMaxHp);
		GameDirector.say(enemyName + ": " + enemyCurrentHp + "/" + enemyMaxHp);
		ArrayList<Skill> playerSkillSet = GameDirector.getPlayer().getSkillSet();
		String playerOptions = new String();
		for (int i = 0; i < playerSkillSet.size(); i++) {
			playerOptions += i + " - " + playerSkillSet.get(i).name();
		}
		return true;
	}

		// Execution/Testing Methods:
	public static void main(String[] args) {
		GameDirector.startGame();
	}

}
