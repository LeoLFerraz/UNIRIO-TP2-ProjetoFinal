package com.googlecode.lanterna.test.gui.layout;

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
import com.googlecode.lanterna.test.TestTerminalFactory;
import com.googlecode.lanterna.test.gui.PanelTest.TextFillComponent;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.TextGraphics;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.AbstractComponent;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.SizePolicy;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.test.TestTerminalFactory;


public class gameTPII {

	public static void main(String[] args) {

        final GUIScreen guiScreen = new TestTerminalFactory(args).createGUIScreen();
        guiScreen.getScreen().startScreen();
        //Windows
         final Window starting1 = new Window("");
         final Window starting2 = new Window("");
         final Window starting3 = new Window("");
         final Window starting4 = new Window("");
         final Window mainWindow = new Window("Engine RPG game");
        //Windonws starting game
        TextArea welcome = new TextArea("Welcome to the Game!");
     //  starting1.wait(1000);
      //  Button pressEnter = new Button("Please, press Enter", new Action() {
        //    public void doAction()
          //  {
            //    starting1.close();
            //}
       // });
        starting1.addComponent(welcome);
       // starting1.addComponent(pressEnter);
        guiScreen.showWindow(starting1, GUIScreen.Position.CENTER);
       
        Button startingButton1 = new Button("Starting game in 3...", new Action() {
            public void doAction()
            {
                starting2.close();
            }
        });
        starting2.addComponent(startingButton1);
        guiScreen.showWindow(starting2, GUIScreen.Position.CENTER);
        
        Button startingButton2 = new Button("Starting game in 2...", new Action() {
            public void doAction()
            {
                starting3.close();
            }
        });
        starting3.addComponent(startingButton2);
        guiScreen.showWindow(starting3, GUIScreen.Position.CENTER);
        
        Button startingButton3 = new Button("Starting game in 1...", new Action() {
            public void doAction()
            {
                starting4.close();
            }
        });
        starting4.addComponent(startingButton3);
        guiScreen.showWindow(starting4, GUIScreen.Position.CENTER);
        //Window Player chooses
        Panel mainPanel = new Panel(Panel.Orientation.HORISONTAL);
        mainWindow.addComponent(new Label("Please, type your desired nickname:"));
        mainWindow.addComponent(new TextBox(20, ""));
        Button warrior = new Button("Warrior", new Action() {
            public void doAction()
            {
                guiScreen.closeWindow();
            }
        });

        TextArea warriorDescription = new TextArea("A sturdy, honored fighter that overcomes his foes with use of brute force. Not very smart, though.");
        Button ranger = new Button("Ranger", new Action() {
            public void doAction()
            {
                guiScreen.closeWindow();
            }
        });

        TextArea rangerDescription = new TextArea("Balanced fighter raised in the mystic wilds.");
        Button mage = new Button("Mage", new Action() {
            public void doAction()
            {
                guiScreen.closeWindow();
            }
        });

        TextArea mageDescription = new TextArea("An old scholar that specialized in channeling the destructive power of the arcane.");
        Button thief= new Button("Thief", new Action() {
            public void doAction()
            {
                guiScreen.closeWindow();
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
        guiScreen.getScreen().stopScreen();
        
        
        
        
        
        
        


	}

}
