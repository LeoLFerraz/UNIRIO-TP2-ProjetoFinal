package corepckg;
import java.util.Scanner;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

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
	private static int gameInterface; // Used to determine how user input and output will be handled;
	
	private static int gameState; // Used as an intermediary for handling user input and system output;
								  // [gameState system must be refactored to refer to an ENUM obj with possible values]
								  // [Once refactored, check setters validations]
	private static final Scanner userInput = new Scanner(System.in); // Used for handling user input;
	
	private static Player player; // Here's the thing with this variable: the Player reference in GameDirector SHOULD be final,
								  // but we can only set final variables in its initialization or in the constructor, and
								  // "player" in initialized later into the game;
								  // We have two possible solutions: declare the attribute as non-final private and have
								  // no setters for it (which is viable for our project), or declare it as final and have it's
								  // handled instead of calling another constructor when we'd originally do so (which is not
								  // not viable as Actor and Player both have final attributes themselves).
								  // We opt for the first solution.
								  
	
	// Getters:
	public static int getGameState() {
		return GameDirector.gameState;
	}
	
	// Setters:
	public static void setGameState(int newGS) { // [recheck validations once GS system is refactored to use ENUM]
		if (newGS < 0) {
			// [THROW EXCEPTION: INVALID GAME STATE PARAMETER DETECTED]
			System.out.println("Invalid game state. Aborting.");
		}
		else {
			GameDirector.gameState = newGS;
		}
	}
	
	// Methods:
	public static void startTerminalGame() { // Starts the game in the IDE's console interface.
		GameDirector.say("Welcome to the game!");
		GameDirector.say("Press Enter to continue.");
		GameDirector.waitEnterKey();
		GameDirector.say("Starting game in 3...");
		GameDirector.waitSeconds(1);
		GameDirector.say("Starting game in 2...");
		waitSeconds(1);
		GameDirector.say("Starting game in 1...");
		GameDirector.waitSeconds(1);
		GameDirector.goToNewGameScreen();
	}
	
	private static void goToNewGameScreen() {
		clearTerminal();
		GameDirector.say("Please, type your desired nickname");
		String playerName = GameDirector.waitString();
		GameDirector.say("Choose your class:");
		GameDirector.say("1 - Warrior: A sturdy, honored fighter that overcomes his foes with use of brute force. Not very smart, though.");
		GameDirector.say("2 - Ranger: Balanced fighter raised in the mystic wilds.");
		GameDirector.say("3 - Mage: An old scholar that specialized in channeling the destructive power of the arcane.");
		GameDirector.say("4 - Thief: An agile burglar that doesn't know what 'luck of the draw' means.");
		PlayerClass playerClass = PlayerClass.getClassByClassCode(GameDirector.waitInt());
		GameDirector.player = new Player(playerName, playerClass);
	}
	
	// Output Handling Methods: // These methods are meant to provide shorthands for the text interface and as fallback in case Lanterna is not available;	
	public static void say(String string) { // Prints and breaks line. Later on, we can use this function to stylize the output text.
		System.out.println(string);
	}
	
	public static void sayil(String string) { // Prints inline;
		System.out.print(string);
	}
	
	public static void sayil(int anyParam, String string, int anotherParam) { // Prints inline with a space before the string starts and after it ends;
		System.out.print(" " + string + " ");
	}
	
	public static void sayil( String string, int anyParam) { // Prints inline with a space after the string ends;
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
		// [needs exception handling that asks for the input again with a generic message]
		return userInput.nextInt();
	}
	
	public static int waitInt(int[] allowedValues) {
		int input = userInput.nextInt();
		if (contains(allowedValues, input) {
			
		}
	}
	
	// Game Events Handling Methods:

	// Execution/Testing:
	public static void main(String[] args) {
		GameDirector.startTerminalGame();
	}

}
