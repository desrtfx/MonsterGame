package tutorials;

import java.util.Scanner;

public class MonsterGame {

	public static void main(String[] args) {

		MonsterGame game = new MonsterGame();
		
		// Initialize the player Object
		Player player = new Player();
		
		// Initialize the Scanner to make it available 
		Scanner in = new Scanner(System.in);
		
		// names of the Monsters
		String[] enemies = { "Count Dooku", "Azeroth", "Zuul", "The Predator", "Alien Queen" };
		
		// Display the title
		game.displayTitle();
		
		// Display the instructions only for the first time
		game.displayInstructions();
		
		// Here the main game loop starts
		
		// TODO: create game loop
		
		// Get User menu choice
		int choice = game.handleMainMenu(in);
		// evaluate the menu choices
		switch (choice) {
		
		
		
		}
		
		
		
		
		// Last command in the program, close the Scanner to
		// avoid a resource leak
		in.close();
		
	}

	private void displayInstructions() {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t***       I N S T R U C T I O N S       ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***  This game is about staying alive   ***");
		System.out.println("\t***  while killing monsters.            ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***  Each turn, you can decide to:      ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***     (1) Attack a monster            ***");
		System.out.println("\t***     (2) Drink a health potion       ***");
		System.out.println("\t***     (3) Run away                    ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***  Attacking a monster hurts the      ***");
		System.out.println("\t***  monster. You might also get hurt.  ***");
		System.out.println("\t***  Hit the monster until it's health  ***");
		System.out.println("\t***  reaches 0 while keeping your       ***");
		System.out.println("\t***  health as high as possible.        ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***  You have a limited number of       ***");
		System.out.println("\t***  health potions that restore part   ***");
		System.out.println("\t***  of your health.                    ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*******************************************");
		
	}

	private void displayTitle() {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t***            Monster Battle           ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*** a (stupid) game of killing monsters ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*******************************************");
		System.out.println();
	}

	private int handleMainMenu(Scanner in) {
		
		
		return 0;
	}
	
	
	
	
}
