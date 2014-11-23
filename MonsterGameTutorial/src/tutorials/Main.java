package tutorials;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Main game = new Main();
		
		// Initialize the Game GUI
		TxtGUI gui = new TxtGUI();

		// Initialize the player Object
		Player player = new Player();


		// names of the Monsters
		String[] enemies = { "Count Dooku", "Azok", "Zuul", "The Predator",
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
