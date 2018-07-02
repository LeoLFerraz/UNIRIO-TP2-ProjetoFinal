package corepckg;


import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.component.TextBox;
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


public class GUIInterface  {
	
	public static void main(String[] args){
		final SwingTerminal myTerminal = new SwingTerminal();
		final Screen myScreen = new Screen(myTerminal); 
        final GUIScreen guiScreen = new GUIScreen(myScreen);
        guiScreen.getScreen().startScreen();
        // create Windows and their variables
         final Window starting1 = new Window("");
         final Window starting2 = new Window("");
         final Window starting3 = new Window("");
         final Window starting4 = new Window("");
         final Window mainWindow = new Window("Engine RPG game");
         Button exitGame = new Button("Exit", new Action(){
        	 public void doAction(){
        		guiScreen.closeWindow();
        	 }
         });
		
		 
        //Windonws starting game
        TextArea welcome = new TextArea("Welcome to the Game!");
        Button pressEnter = new Button("Please, press Enter", new Action() {
            public void doAction()
            {
              String choosenClass = "Warrior";
              starting1.close();
          }
        });
        starting1.addComponent(welcome);
       starting1.addComponent(pressEnter);
        guiScreen.showWindow(starting1, GUIScreen.Position.CENTER);
       
        Button startingButton1 = new Button("Loading textures...", new Action() {
            public void doAction()
            {
                starting2.close();
            }
        });
        starting2.addComponent(startingButton1);
        guiScreen.showWindow(starting2, GUIScreen.Position.CENTER);
        
        Button startingButton2 = new Button("Unpacking models...", new Action() {
            public void doAction()
            {
                starting3.close();
            }
        });
        starting3.addComponent(startingButton2);
        guiScreen.showWindow(starting3, GUIScreen.Position.CENTER);
        TerminalSize size  = new TerminalSize(100, 200);
 
        TextArea wait = new TextArea(new TerminalSize(50, 3),"Oh wait...");
        Button startingButton3 = new Button("...there aren't any. This is a text-based game!", new Action() {
            public void doAction()
            {
                starting4.close();
            }
        });
        starting4.addComponent(wait);
        starting4.addComponent(startingButton3);
        guiScreen.showWindow(starting4, GUIScreen.Position.CENTER);
        //Window Player chooses
        Panel mainPanel = new Panel(Panel.Orientation.HORISONTAL);
        mainWindow.addComponent(new Label("Please, type your desired nickname:"));
        TextBox nickname = new TextBox("",20);
        mainWindow.addComponent(nickname);
        Button warrior = new Button("Warrior", new Action() {
			public void doAction()
            {
                mainWindow.close();
            }
        });

        TextArea warriorDescription = new TextArea("A sturdy, honored fighter that overcomes his foes with use of brute force. Not very smart, though.");
        Button ranger = new Button("Ranger", new Action() {
            public void doAction()
            {
            	mainWindow.close();
            }
        });

        TextArea rangerDescription = new TextArea("Balanced fighter raised in the mystic wilds.");
        Button mage = new Button("Mage", new Action() {
            public void doAction()
            {
            	mainWindow.close();
            }
        });

        TextArea mageDescription = new TextArea("An old scholar that specialized in channeling the destructive power of the arcane.");
        Button thief= new Button("Thief", new Action() {
            public void doAction()
            {
            	mainWindow.close();
            }
        });

        TextArea thiefDescription = new TextArea("An agile burglar that doesn't know what 'luck of the draw' means.");
        mainWindow.addComponent(warrior);
        mainWindow.addComponent(warriorDescription);
        mainWindow.addComponent(ranger);
        mainWindow.addComponent(rangerDescription);
        mainWindow.addComponent(mage);
        mainWindow.addComponent(mageDescription);
        mainWindow.addComponent(thief);
        mainWindow.addComponent(thiefDescription);
        guiScreen.showWindow(mainWindow, GUIScreen.Position.CENTER);
       

		TextBox choosenClass = new TextBox("",20);
		final Window floor = new Window(nickname + ", the " + choosenClass );
        
		Floor currentFloor = new Floor();
		String currentEnemyName = currentFloor.getEnemyName();
        TextArea numberFloor = new TextArea("The stairs take you to Floor #" + Floor.getNumberOfFloors());
        TextArea floorText = new TextArea("Waiting there, at the very center of the room is a... ");
        TextArea enemyName = new TextArea(currentEnemyName);
        TextArea startingText = new TextArea("Starting battle...");
        //boolean playerWins = GameDirector.executeBattle(currentFloor);
		//if (playerWins) {
		//	return true;
	//	}
		//else {
		//	return false;
		//}

        
        
		floor.addComponent(numberFloor);
        floor.addComponent(floorText);
        floor.addComponent(enemyName);
        floor.addComponent(startingText);
        floor.addComponent(exitGame);
        guiScreen.showWindow(floor, GUIScreen.Position.CENTER);
        guiScreen.getScreen().stopScreen();
        
	}
	
public static void directorCall(){
	main(null);
}
}