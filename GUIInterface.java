package corepckg;


import java.util.ArrayList;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.RadioCheckBoxList;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.TextGraphics;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.AbstractComponent;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;


public abstract class GUIInterface  {
	public static void main(String[] args){
		startGUIGame();
	}
	final static SwingTerminal myTerminal = new SwingTerminal();
	final static Screen myScreen = new Screen(myTerminal); 
	final static GUIScreen guiScreen = new GUIScreen(myScreen);
	public static boolean cancelThread = false;

	public static void startGUIGame(){
		guiScreen.getScreen().startScreen();
		final Window gameStartWindow = new Window("Starting Game");
		Button startGameButton = new Button("Press Enter to begin.", new Action(){
			public void doAction(){startAnimation(gameStartWindow);}});
		gameStartWindow.addComponent(startGameButton);
		GameDirector.waitSeconds(0.5);
		//TextArea loadingGameText = new TextArea("Loading textures...");
		//TextArea unpackingGameText = new TextArea("Unpacking models...");
		//TextArea waitGameText = new TextArea("Wait! We don't need it!");
		//loadingGameText.setMinimumSize(new TerminalSize(25,2));
		//unpackingGameText.setMinimumSize(new TerminalSize(25,2));
		//waitGameText.setMinimumSize(new TerminalSize(25,2));
		//gameStartWindow.addComponent(loadingGameText);
		//gameStartWindow.addComponent(unpackingGameText);
		//gameStartWindow.addComponent(waitGameText);
		guiScreen.showWindow(gameStartWindow, GUIScreen.Position.CENTER);
	}
	public static void startAnimation(Window window){
		guiScreen.runInEventThread(new Action(){
			public void doAction(){
				window.close();
				goToNewGameScreen();
			}
		});
	}
	public static void goToNewGameScreen(){
		final Window newGameWindow = new Window("");
		newGameWindow.addComponent(new Label("Please, type your desired nickname:"));
		TextBox nickname = new TextBox ("",35);

		newGameWindow.addComponent(nickname);
		TextArea warriorDescription = new TextArea("Warrior: A sturdy, honored fighter that overcomes his foes with use of brute force. Not very smart, though.");
		TextArea rangerDescription = new TextArea("Ranger: Balanced fighter raised in the mystic wilds.");
		TextArea mageDescription = new TextArea("Mage: An old scholar that specialized in channeling the destructive power of the arcane.");
		TextArea thiefDescription = new TextArea("Thief: An agile burglar that doesn't know what 'luck of the draw' means.");
		Button warrior = new Button("Warrior", new Action() {
			public void doAction()
			{
				if(nickname.getText().equals("")) {
					MessageBox.showMessageBox(guiScreen, "Wait,Dear...","You have to put your name!", DialogButtons.OK);
				}
				else{
					GameDirector.player = new Player(nickname.getText(),PlayerClass.getClassByClassCode(1));
					newGameWindow.close();
					nextFloor();
				}
			}
		});
		Button ranger = new Button("Ranger", new Action() {
			public void doAction()
			{
				if(nickname.getText().equals("")) {
					MessageBox.showMessageBox(guiScreen, "Wait,Dear...","You have to put your name!", DialogButtons.OK);
				}
				else{
					GameDirector.player = new Player(nickname.getText(),PlayerClass.getClassByClassCode(2));
					newGameWindow.close();
					nextFloor();
				}
			}
		});
		Button mage = new Button("Mage", new Action() {
			public void doAction()
			{
				if(nickname.getText().equals("")) {
					MessageBox.showMessageBox(guiScreen, "Wait,Dear...","You have to put your name!", DialogButtons.OK);
				}
				else{
					GameDirector.player = new Player(nickname.getText(),PlayerClass.getClassByClassCode(3));
					newGameWindow.close();
					nextFloor();
				}
			}
		});
		Button thief= new Button("Thief", new Action() {
			public void doAction()
			{
				if(nickname.getText().equals("")) {
					MessageBox.showMessageBox(guiScreen, "Wait,Dear...","You have to put your name!", DialogButtons.OK);
				}
				else{
					GameDirector.player = new Player(nickname.getText(),PlayerClass.getClassByClassCode(4));
					newGameWindow.close();
					nextFloor();
				}
			}
		});
		Button exitGame= new Button("Exit", new Action() {
			public void doAction()
			{
				guiScreen.getScreen().stopScreen();
			}
		});
		warriorDescription.setMinimumSize(new TerminalSize(100,2));
		rangerDescription.setMinimumSize(new TerminalSize(100,2));
		mageDescription.setMinimumSize(new TerminalSize(100,2));
		thiefDescription.setMinimumSize(new TerminalSize(100,2));
		newGameWindow.addComponent(warrior);
		newGameWindow.addComponent(ranger);
		newGameWindow.addComponent(mage);
		newGameWindow.addComponent(thief);
		newGameWindow.addComponent(warriorDescription);
		newGameWindow.addComponent(rangerDescription);
		newGameWindow.addComponent(mageDescription);
		newGameWindow.addComponent(thiefDescription);
		newGameWindow.addComponent(exitGame);
		guiScreen.showWindow(newGameWindow, GUIScreen.Position.CENTER);
	}
	/*public static void startMatch(){
		boolean playerWins;
		do {
			playerWins = nextFloor();
		} while (playerWins);
	}*/
	public static void nextFloor(){
		Window floorWindow = new Window("Sir." + GameDirector.getPlayer().getName() );
		Floor currentFloor = new Floor();
		String currentEnemyName = currentFloor.getEnemyName();
		TextArea currentFloorText = new TextArea("The stairs take you to Floor #" + Floor.getNumberOfFloors());
		GameDirector.waitSeconds(1);
		TextArea waitThereText = new TextArea("Waiting there, at the very center of the room is a... ");
		GameDirector.waitSeconds(0.7);
		TextArea currentEnemyText = new TextArea(currentEnemyName);
		Button startingButton = new Button("Starting battle...", new Action(){
			public void doAction(){
				boolean playerWins = true;
				if (playerWins) {
					floorWindow.close();
					executeBattle(currentFloor);
				}
				else {
					floorWindow.close();
				}
			}
		});
		waitThereText.setMinimumSize(new TerminalSize(50,2));
		currentEnemyText.setMinimumSize(new TerminalSize(55,2));
		floorWindow.addComponent(waitThereText);
		floorWindow.addComponent(currentEnemyText);
		floorWindow.addComponent(startingButton);
		guiScreen.showWindow(floorWindow, GUIScreen.Position.CENTER);	
	}
	static void executeBattle(Floor currentFloor) { // True for player wins, false for player loses;
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
		Window battleWindow = new Window("Fight!");
		//Informations to show
		String enemyName = currentFloor.getEnemyName();
		int enemyCurrentHp = currentFloor.getEnemyCurrentHp();
		int enemyMaxHp = currentFloor.getEnemyMaxHp();
		String playerName = GameDirector.getPlayer().getName();
		int playerCurrentHp = GameDirector.getPlayer().getCurHp();
		int playerMaxHp = GameDirector.getPlayer().getMaxHp();
		TextArea playerInformation = new TextArea ("Player: " + playerName + " / HP: " + playerMaxHp);
		TextArea enemyInformation = new TextArea("Enemy: " + enemyName + " / HP: " + enemyMaxHp);
		ArrayList<Skill> playerSkillSet = GameDirector.getPlayer().getSkillSet();
		final RadioCheckBoxList listBox = new RadioCheckBoxList();
		Thread thread = new Thread() {
			@Override
			public void run()
			{
				for (int i = 0; i < playerSkillSet.size(); i++) {
					try {
						Thread.sleep(250);
					}
					//castSkillIndex = GameDirector.waitInt();
					//damageDealt = GameDirector.getPlayer().castSkill(castSkillIndex-1, currentFloor.getEnemy()); // [Needs refactoring to allow multiple entities as target.]
					catch(InterruptedException e) {}
					final String count = playerSkillSet.get(i).name();
					guiScreen.runInEventThread(new Action() {
						public void doAction()
						{
							listBox.addItem(" - " + count );
						}
					});
					if(cancelThread)
						break;
				}
			}
		};
		playerInformation.setMinimumSize(new TerminalSize(50,2));
		enemyInformation.setMinimumSize(new TerminalSize(50,2));
		battleWindow.addComponent(playerInformation);
		battleWindow.addComponent(enemyInformation); 
		battleWindow.addComponent(listBox);
		thread.start();
		guiScreen.showWindow(battleWindow, GUIScreen.Position.CENTER);
		cancelThread = true;
	}
}
