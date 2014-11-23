package tutorials;

import java.util.Scanner;

public class MonsterGame {

	public static void main(String[] args) {

		MonsterGame game = new MonsterGame();
		
		// Initialise the Game GUI
		MonsterGameTxtGUI gui = new MonsterGameTxtGUI();

		// Initialize the player Object
		Player player = new Player();


		// names of the Monsters
		String[] enemies = { "Count Dooku", "Azeroth", "Zuul", "The Predator",
				"Alien Queen" };

		// Display the title
		gui.displayTitle();

		// Display the instructions only for the first time
		gui.displayInstructions();

		// Here the main game loop starts

		// TODO: create game loop

		// Get User menu choice
		int choice = gui.handleMainMenu();
		// evaluate the menu choices
		switch (choice) {

		}



	}





}
