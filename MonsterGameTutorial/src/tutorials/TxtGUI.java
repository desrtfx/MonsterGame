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
		System.out.println("\t***     (1)   Attack a monster          ***");
		System.out.println("\t***     (2)   Drink a health potion     ***");
		System.out.println("\t***     (3)   Run away                  ***");
		System.out.println("\t***     (4)   Quit Game                 ***");
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
		System.out.println();

	}

	public int handleMainMenu() {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t***       What do you want to do?       ***");
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

	public void displayNewMonster(Monster monster) {
		System.out.println("\t*******************************************");
		System.out.println("\t***                                     ***");
		System.out.println("\t*** MASTER!                             ***");
		System.out.println("\t*** A new monster has appeared!         ***");
		System.out.println("\t***                                     ***");
		System.out.println(String.format("\t*** Name:   %-27s ***",monster.getName()));
		System.out.println(String.format("\t*** Health: %-27d ***", monster.getHealth()));
		System.out.println("\t***                                     ***");
		System.out.println("\t*******************************************");
	}

	public void displayFight(Player player, Monster monster, int damagePlayer, int damageMonster) {
		// TODO displayFight Auto-generated method stub
		
	}

	public void displayHealthPotion(Player player, boolean success) {
		// TODO displayHealthPotion Auto-generated method stub
		
	}

	public void displayRunAway(Player player, Monster monster) {
		// TODO displayRunAway Auto-generated method stub
		
	}

	public void displayEndMessage(Player player) {
		// TODO displayEndMessage Auto-generated method stub
		
	}

	public void displayMonsterKill(Player player, Monster monster) {
		// TODO displayMonsterKill Auto-generated method stub
		
	}

	public void displayPlayerKill(Player player, Monster monster) {
		// TODO displayPlayerKill Auto-generated method stub
		
	}

	public void displayStats(Player player, Monster monster) {
		// TODO displayStats Auto-generated method stub
		
	}

	public void displayReceivePotion(Player player, Monster monster, int potions) {
		// TODO displayReceivePotion Auto-generated method stub
		
	}

	
	
}
