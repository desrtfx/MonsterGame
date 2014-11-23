package tutorials;

import java.util.Random;
import java.util.Scanner;

public class Main {

	// Constants
	public static final int MAX_ENEMY_HEALTH = 75;
	public static final int MAX_ENEMY_ATTACK_DAMAGE = 25;
	public static final int MAX_PLAYER_ATTACK_DAMAGE = 50;

	public static void main(String[] args) {

		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		// Game Variables
		String[] enemies = { "Sully's mom", "Old Dildo", "HER FACE!!!!", "Assassin" };

		// Player variables
		int health = 100;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // Percentage

		boolean running = true;

		System.out.println("\t Welcome to Sully's Butthole");
		// Label
		GAME: while (running) {
			System.out.println("\t-----------------------------");

			int enemyHealth = rand.nextInt(MAX_ENEMY_HEALTH);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				String input = displayMenu(in, health, enemy, enemyHealth);
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(MAX_PLAYER_ATTACK_DAMAGE);
					int damageTaken = rand.nextInt(MAX_ENEMY_ATTACK_DAMAGE);

					enemyHealth -= damageDealt;
					health -= damageTaken;

					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage");
					System.out.println("\t> You recieved " + damageTaken + " in retaliation");

					if (health < 1) {
						System.out.println("\t You have taken too much damage, you are too weak to go on");
						break;
					}
				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t You drank a health potion, healed for :" + healthPotionHealAmount + "."
								+ "\n\t> You now have " + health + " HP." + "\n\t> You now have " + numHealthPotions
								+ " health potions left. \n");
					} else {
						System.out.println("\t> You have no health potions left, defeat enemies for a change to get one!");
					}
				} else if (input.equals("3")) {
					System.out.println("\tYou run away from the " + enemy + "!");

					continue GAME;
					
				} else {
					System.out.println("\tInvalid command");
				}
			}
			if (health < 1) {
				System.out.println("You are swallowed by the darkness of sully's ass never to be seen again.");
				break;
			}

			System.out.println("-----------------------------");
			System.out.println("#" + enemy + " was defeated!#");
			System.out.println("#You have " + health + " HP left#");
			// if the random number is less than 40 it drops
			if (rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println("#The " + enemy + " dropped a health potion!#");
				System.out.println("#You now have " + numHealthPotions + " health potion(s).#");
			}
			System.out.println("-----------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue Fighting");
			System.out.println("2. Exit dungeon");

			String input = in.nextLine();

			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("invalid command");
				input = in.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("You continue your adventure.");
			} else if (input.equals("2")) {
				System.out.println("You exit the dungeon.");
				break;
			}
		}
		{
			System.out.println("####################");
			System.out.println("#THANKS FOR PLAYING#");
			System.out.println("#####################");
		}
	}

	/**
	 * @param in
	 * @param health
	 * @param enemy
	 * @param enemyHealth
	 * @return
	 */
	private static String displayMenu(Scanner in, int health, String enemy, int enemyHealth) {
		System.out.println("\tYour HP:" + health);
		System.out.println("\t" + enemy + "s HP:" + enemyHealth);
		System.out.println("\n\tWhat would you like to do");
		System.out.println("\t1. Attack");
		System.out.println("\t2. Drink health potion");
		System.out.println("\t3. Run");

		String input = in.nextLine();
		return input;
	}
}