package tutorials;

import java.util.Scanner;

public class TxtGUI {
	
	private Scanner in;
	
	TxtGUI() {
		in = new Scanner(System.in);
	}

	public void displayTitle() {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t***            Monster Battle           ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*** a (stupid) game of killing monsters ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*******************************************");
		System.out.println();
	}
	
	public void displayInstructions() {
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
	
	public int handleMainMenu() {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t***            MAIN MENU                ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t***     (1)   Attack Monster            ***");
		System.out.println("\t***     (2)   Drink Health Potion       ***");
		System.out.println("\t***     (3)   Run Away                  ***");
		System.out.println("\t***     (4)   Quit Game                 ***");
		System.out.println("\t***                                     ***");
		System.out.println("\t*******************************************");
		System.out.println();

		// Menu Loop
		int choice;
		do {
			System.out.print("Please choose your action (1..4): ");
			choice = in.nextInt();
			if ((choice < 1) || (choice > 4)) {
				System.out.println("Invalid choice!");
				System.out.println();
			}
		} while ((choice < 1) || (choice > 4));
		return choice;
	}
	
}
